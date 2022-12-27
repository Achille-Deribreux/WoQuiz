package com.woquiz.quiz.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.woquiz.utils.BasicUtils;
import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.user.User;

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
