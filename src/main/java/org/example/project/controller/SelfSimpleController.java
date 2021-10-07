package org.example.project.controller;

import org.example.project.repository.CamundaDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/self")
public class SelfSimpleController {
    private final CamundaDbRepository repository;

    @Autowired
    public SelfSimpleController(CamundaDbRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/del_all")
    public String deleteAllProcessInstances() {
        repository.removeAllProcessInstances();
        return "remove all";
    }

    @GetMapping("/del_act")
    public String deleteActiveProcessInstances() {
        repository.removeAllActiveProcessInstances();
        return "remove active";
    }
}
