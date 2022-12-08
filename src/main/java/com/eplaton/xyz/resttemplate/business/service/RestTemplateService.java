package com.eplaton.xyz.resttemplate.business.service;

import org.springframework.http.ResponseEntity;

import com.eplaton.xyz.resttemplate.transfer.MemberDTO;



public interface RestTemplateService {

    public String getAroundHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();

}
