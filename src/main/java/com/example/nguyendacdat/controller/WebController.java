package com.example.nguyendacdat.controller;

import com.example.nguyendacdat.entity.BookEntity;
import com.example.nguyendacdat.entity.PublisherEntity;
import com.example.nguyendacdat.service.BookService;
import com.example.nguyendacdat.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    BookService bookService;
    @Autowired
    PublisherService publisherService;

    @GetMapping({"/", "/index"})
    public String index(Model model,@Param("namebook") String namebook){
        List<BookEntity> books = bookService.getAll(namebook);
        List<PublisherEntity> publishers = publisherService.getAllPublisher(namebook);
        model.addAttribute("books",books);
        model.addAttribute("publishers",publishers);
        model.addAttribute("namebook", namebook);
        return "index";

    }

    @GetMapping("createbook")
    public String createBook(Model model,@Param("namepublisher") String namepublisher) {
        BookEntity books = new BookEntity();
        model.addAttribute("books", books);
        List<PublisherEntity> publishers = publisherService.getAllPublisher(namepublisher);
        model.addAttribute("publishers", publishers);
        return "createbook";
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute BookEntity b){
        bookService.createBook(b);
        return "redirect:/";
    }

    @GetMapping("createpublisher")
    public String createPublisher(Model model) {
        PublisherEntity publishers = new PublisherEntity();
        model.addAttribute("publishers", publishers);
        return "createpublisher";
    }



    @PostMapping("/savepublisher")
    public String savePublisher(@ModelAttribute PublisherEntity p){
        publisherService.createPublisher(p);
        return "redirect:/";
    }


}
