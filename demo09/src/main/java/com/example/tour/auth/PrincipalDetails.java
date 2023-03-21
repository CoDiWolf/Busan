package com.example.tour.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tour.model.Member;
import com.example.tour.repository.MemberRepository;

@Service
public class PrincipalDetails implements UserDetailsService {
	@Autowired
	private MemberRepository mRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   System.out.println("loadUserByUsername");
	   Member member =   mRepository.findByUsername(username);
	  if(member ==null) return null;
	  // 占쎌돳占쎌뜚占쎌뵠占쎌뵬筌롳옙 占쎈뻻占쎄괠�뵳�뗫뼒揶쏉옙 占쎌읅占쎌뒠占쎈┷ User �뵳�뗪쉘
	  PrincipalUser puser = new PrincipalUser(member);
	  System.out.println("puser :" + puser);
		return puser;
	}
	
}
