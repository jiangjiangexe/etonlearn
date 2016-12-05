package com.jiang.etonlearn.controller;

import com.jiang.etonlearn.annotation.Mask;
import com.jiang.etonlearn.view.First;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class FirstController {

    @Mask
    @RequestMapping("/query")
    @ResponseBody
    public First query(@RequestParam String password, @RequestParam String username){
        First first = new First();
        first.setPassword(password);
        first.setUsername(username);
        return first;
    }
}
