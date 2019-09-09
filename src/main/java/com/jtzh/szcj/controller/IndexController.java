package com.jtzh.szcj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController {

    @RequestMapping("/")
    public void index(HttpServletResponse responsec)throws IOException {
        responsec.sendRedirect("templates/jurong/index.html");
    }
}
