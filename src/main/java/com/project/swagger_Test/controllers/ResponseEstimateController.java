package com.project.swagger_Test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.swagger_Test.dto.CompanyDTO;
import com.project.swagger_Test.services.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/response_estimate")
@RequiredArgsConstructor
@Tag(name = "Estimate Controller", description = "Response Estimate API")
public class ResponseEstimateController {
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/signup")
	@Operation(summary = "업체 회원가입", description = "업체 측에서 회원가입 할 때 사용하는 API")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "1000", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "2002", description = "이미 가입된 계정입니다.", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "4000", description = "데이터베이스 연결에 실패하였습니다.", content = @Content(mediaType = "application/json")),
	        @ApiResponse(responseCode = "4011", description = "비밀번호 암호화에 실패하였습니다.", content = @Content(mediaType = "application/json"))
	})
	public @ResponseBody ResponseEntity<CompanyDTO.SignupRes> signUp(@RequestBody CompanyDTO.SignupReq signup) {
	    try {
	        return ResponseEntity.ok(companyService.signup(signup));
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
}
