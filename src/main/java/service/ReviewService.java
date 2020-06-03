package service;

import model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findById(Long id);

    void save(Review review);

    void remove(Long id);
}
