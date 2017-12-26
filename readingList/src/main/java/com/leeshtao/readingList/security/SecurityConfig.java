package com.leeshtao.readingList.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.leeshtao.readingList.dao.ReaderRepository;

/**
 * @author 李世涛
 * @date 2017年12月9日
 * 
 */
//@Profile("production")
/**
 * 此注解对应的profile没有启动,此SecurityConfig就不会启用,而使用默认的,
 * 则需要输入用户名user,和控制台输出的"Using default security password:"
 * 
 * 没有此注解,那么将直接引用此SecurityConfig
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ReaderRepository readerRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/").access("hasRole('READER')") //要求登录者有READER角色
				.antMatchers("/**").permitAll()
			.and()
			
			.formLogin()
				.loginPage("/login")						//设置登录表单的路径
				.failureUrl("/login?error=true");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(new UserDetailsService() { //自定义UserDetailsService
				
				@Override
				public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					return readerRepository.findOne(username);
				}
			});
	}
	
}
