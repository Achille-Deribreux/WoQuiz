package com.woquiz.word.repository;

import java.util.ArrayList;
import java.util.List;

import com.woquiz.common.BaseEntity_;
import com.woquiz.user.model.User;
import com.woquiz.user.model.User_;
import com.woquiz.utils.BasicUtils;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;
import com.woquiz.word.model.Word_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomWordRepositoryImpl implements CustomWordRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Word> findByCriteria(WordCriteria wordCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Word> criteriaQuery = criteriaBuilder.createQuery(Word.class);
        BasicUtils.ConditionalList<Predicate> conditionalList = BasicUtils.ConditionalList.of(new ArrayList<>());
        Root<Word> wordRoot = criteriaQuery.from(Word.class);
        Join<Word, User> userJoin = wordRoot.join(BaseEntity_.USER, JoinType.LEFT);

        conditionalList
                .add(wordCriteria.getBasicWordContains()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(wordRoot.get(Word_.BASIC_WORD))),toLike(wordCriteria.getBasicWordContains().toUpperCase())))
                .add(wordCriteria.getTranslationContains()!=null,()->criteriaBuilder.like((criteriaBuilder.upper(wordRoot.get(Word_.TRANSLATION))),toLike(wordCriteria.getTranslationContains().toUpperCase())))
                .add(wordCriteria.getUserId()!=null,()->criteriaBuilder.equal(userJoin.get(User_.ID),wordCriteria.getUserId()))
                .add(wordCriteria.getStatus()!=null,()-> wordRoot.get(Word_.STATUS).in(wordCriteria.getStatus()))
                .add(wordCriteria.getLevel()!=null,()-> wordRoot.get(Word_.LEVEL).in(wordCriteria.getLevel()));
        criteriaQuery.where(conditionalList.toList().toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(wordRoot.get(Word_.ID)));
        TypedQuery<Word> query = entityManager.createQuery(criteriaQuery);

        if(wordCriteria.getPageSize()!=null && wordCriteria.getPageNr()!=null)
            query.setMaxResults(wordCriteria.getPageSize()).setFirstResult((wordCriteria.getPageNr()-1) * wordCriteria.getPageSize());
        return query.getResultList();
    }

    private String toLike(String value){
        if(value.contains("*"))
            return value.replace("*","%");
        return "%"+value+"%";
    }
}
