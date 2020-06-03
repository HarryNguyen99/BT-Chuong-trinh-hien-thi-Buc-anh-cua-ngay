package service.impl;

import model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ReviewRepository;
import service.ReviewService;

import java.util.List;

public class ReviewServiecimpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void remove(Long id) {
        reviewRepository.remove(id);
    }
}
