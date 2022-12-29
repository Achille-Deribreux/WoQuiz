package com.woquiz.quiz.repository;

import java.util.ArrayList;
import java.util.List;

import com.woquiz.utils.BasicUtils;
import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomQuizRepositoryImpl implements CustomQuizRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Quiz> findByCriteria(QuizCriteria quizCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Quiz> criteriaQuery = criteriaBuilder.createQuery(Quiz.class);
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        Root<Quiz> quizRoot = criteriaQuery.from(Quiz.class);
        Join<Quiz, User> userJoin = quizRoot.join("user", JoinType.LEFT);
        conditionalList
                .add(quizCriteria.getUserId()!=null,()->criteriaBuilder.equal(userJoin.get("id"),quizCriteria.getUserId()))
                .add(quizCriteria.getAttemptDateAfter()!=null,()->criteriaBuilder.lessThanOrEqualTo(quizRoot.get("attemptDate"),quizCriteria.getAttemptDateAfter()));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(quizRoot.get("id")));
        TypedQuery<Quiz> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
