package com.project.swagger_Test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CompanyDTO {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class SignupReq {
		private int cseq;
		private String name;
		private String tel;
		private String address;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class SignupRes {
		private int cseq;
		private String name;
		private String tel;
		private String address;
	}
}
