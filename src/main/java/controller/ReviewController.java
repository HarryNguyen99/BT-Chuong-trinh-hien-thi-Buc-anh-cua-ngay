package controller;

import model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ReviewService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("create")
    public ModelAndView showForm(){
        ModelAndView modelAndView =new  ModelAndView("home");
       modelAndView.addObject("review", new Review());
        return  modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveDanhGia(@ModelAttribute("review") Review review){
        reviewService.save(review);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("review", new Review());
        return modelAndView;
    }


}
