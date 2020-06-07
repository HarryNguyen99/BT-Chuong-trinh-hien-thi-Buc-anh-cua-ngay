package controller;

import model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ReviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ReviewController {

    @ModelAttribute("listDiem")
    public List<Long> diem(){
        List<Long> listDiem = new ArrayList<>();
        listDiem.add((long) 1);
        listDiem.add((long) 2);
        listDiem.add((long) 3);
        listDiem.add((long) 4);
        listDiem.add((long) 5);
        return listDiem;
    }

    @Autowired
    private ReviewService reviewService;

    @GetMapping()
//    public ModelAndView showHome() {
//        return showList(new PageRequest(0,1));
//    }


    public ModelAndView showList(Pageable pageable) {
        Page<Review> reviews =reviewService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("reviews", reviews);
        modelAndView.addObject("review", new Review());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveReview(@ModelAttribute("review") Review review){
        reviewService.save(review);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("review", new Review());
        return modelAndView;
    }

    @PostMapping("like")
    public ModelAndView saveLike(@ModelAttribute("review") Review review){
        reviewService.save(review);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("review", new Review());
        return modelAndView;
    }

}
