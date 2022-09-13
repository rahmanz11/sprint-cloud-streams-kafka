package com.example.demo.controller;

import com.example.demo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Producer producer;

    @PostMapping("/teacher/{id}/{name}/{age}/{subject}")
    public int producerAvroMessage(@PathVariable int id, @PathVariable String name, @PathVariable int age, @PathVariable String subject) {
        producer.produce(id, name, age, subject);
        return HttpStatus.CREATED.value();
    }
}
