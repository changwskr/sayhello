package com.eplaton.xyz.resttemplate.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.resttemplate.business.service.RestTemplateService;
import com.eplaton.xyz.resttemplate.transfer.MemberDTO;

@RestController
@RequestMapping("/api/rest-template-o")
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping(value = "/around-hub")
    public String getAroundHub() {
        return restTemplateService.getAroundHub();
    }

    @GetMapping(value = "/name")
    public String getName() {
        return restTemplateService.getName();
    }

    @GetMapping(value = "/name2")
    public String getName2() {
        return restTemplateService.getName2();
    }

    @PostMapping(value = "/dto")
    public ResponseEntity<MemberDTO> postDto() {
        return restTemplateService.postDto();
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader() {
        return restTemplateService.addHeader();
    }

}
