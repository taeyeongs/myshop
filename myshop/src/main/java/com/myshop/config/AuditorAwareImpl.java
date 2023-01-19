package com.myshop.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//로그인한 사용자의 정보를 등록자와 수정자로 지정
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		//현재 로그인한 사용자의 정보를 가져온다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = "";
		
		if (authentication != null) {
			userId = authentication.getName(); // 사용자의 이름을 가져온다.
		}
		return Optional.of(userId); //사용자의 이를을 등록자와 수정자로 지정
	}

}
