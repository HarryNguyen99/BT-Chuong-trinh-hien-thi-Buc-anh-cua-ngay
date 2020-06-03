package repository.impl;

import model.Review;
import repository.ReviewRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReviewRepositoryimpl implements ReviewRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Review> findAll() {
        TypedQuery<Review> query = em.createQuery("select c from Review c", Review.class);
        return query.getResultList();
    }

    @Override
    public Review findById(Long id) {
        TypedQuery<Review> query = em.createQuery("select c from Review c where c.id=:id",Review.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Review model) {
        if (model.getId() != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Review review = findById(id);
        if (review != null){
            em.remove(review);
        }
    }
}
