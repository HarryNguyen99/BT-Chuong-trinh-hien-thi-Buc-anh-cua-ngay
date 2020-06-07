package service;

import model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ReviewService {
    Page<Review> findAll(Pageable pageable);
    Page<Review> findAllByContentContaining(String content, Pageable pageable);

    Review findById(Long id);

    void save(Review review);

    void remove(Long id);


}
