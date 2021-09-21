package com.fastcampus.programming.dmaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DMakerController {

    @GetMapping("developers")
    public List<String> getAllDevelopers() {
        return Arrays.asList("sudal","dongdong","siva");

    }
}
