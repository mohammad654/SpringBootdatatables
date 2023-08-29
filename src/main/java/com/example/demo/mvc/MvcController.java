package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    // http://localhost:9090/customer
    @GetMapping("/")
    public String homePage() {

        System.out.println("Inside homePage");

        return "home";
    }

    // http://localhost:9090/customer
    @GetMapping("/customer")
    public String customerPage() {

        System.out.println("Inside customerPage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "customerT";
    }

    // http://localhost:9090/reservation
    @GetMapping("/reservation")
    public String reservationPage() {

        System.out.println("Inside reservationPage");

        return "reservation";
    }

    // http://localhost:9090/contact
    @GetMapping("/contact")
    public String contactPage() {

        System.out.println("Inside cantactPage");

        return "contact";
    }

    // http://localhost:9090/blog
    @GetMapping("/blog")
    public String blogPage() {

        System.out.println("Inside blogPage");

        return "blog";
    }

}

