package com.hwan.yaksa.repository;


import com.hwan.yaksa.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class BoardRepository {
    private final EntityManager em;
    private final int SIZE=10;

    public void save(Board board){
        em.persist(board);
    }

    public void delete(Long id){
        Board board = em.find(Board.class, id);
        if(board!=null){
            em.remove(board);
        }
    }

    public List<Board> findAll(Long boardNum){
        String jpql="select B from Board B";
        return em.createQuery(jpql,Board.class).setFirstResult((int)(boardNum-1)*SIZE).setMaxResults(SIZE).getResultList();
    }

    public Board find(Long id){
        return em.find(Board.class,id);
    }

    public Long getCount(){
        String jpql="select count(*) from Board B";
        return  (Long)em.createQuery(jpql).getSingleResult();
    }

}
