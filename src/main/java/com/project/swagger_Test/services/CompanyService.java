package com.project.swagger_Test.services;

import org.springframework.stereotype.Service;

import com.project.swagger_Test.dto.CompanyDTO;

@Service
public class CompanyService {
	public CompanyDTO.SignupRes signup(CompanyDTO.SignupReq signup) {
		return CompanyDTO.SignupRes.builder().cseq(signup.getCseq()).name(signup.getName()).tel(signup.getTel()).address(signup.getAddress()).build();
	}
}
