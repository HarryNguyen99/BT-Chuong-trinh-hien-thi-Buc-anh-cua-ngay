package service.impl;

import model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import repository.ReviewRepository;
import service.ReviewService;



@Transactional
public class ReviewServiecimpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;



    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Page<Review> findAllByContentContaining(String content, Pageable pageable) {
        return reviewRepository.findAllByContentContaining(content, pageable);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findOne(id);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void remove(Long id) {
        reviewRepository.delete(id);
    }
}
