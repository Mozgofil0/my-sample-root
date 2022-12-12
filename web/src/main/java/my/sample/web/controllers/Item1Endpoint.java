package my.sample.web.controllers;

import my.sample.domain.services.Item1Service;
import my.sample.web.models.Item1Model1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Item1Endpoint {

    @Autowired
    Item1Service service;

    @GetMapping("/endpoint1/model1")
    Item1Model1 getDefault() {
        return Item1Model1.mapFrom(service.getById(23));
    }

    @GetMapping("/endpoint1/model1/{id}")
    Item1Model1 getById(@PathVariable Integer id) {
        return Item1Model1.mapFrom(service.getById(id));
    }
}
