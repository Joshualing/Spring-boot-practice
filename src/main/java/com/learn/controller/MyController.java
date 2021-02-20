package com.learn.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/klass/{klassId}/teachers")
    public String getKalss(@PathVariable("klassId") String kalssId, @RequestParam(value = "type", required = false) String type) {
        return  "PathVariable:" + kalssId +" type" + type;
    }
}
