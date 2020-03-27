/**

Delta CONFIDENTIAL


(C) Copyright Delta Electronics, Inc. 2020 All Rights Reserved


NOTICE:  All information contained herein is, and remains the
property of Delta Electronics. The intellectual and technical
concepts contained herein are proprietary to Delta Electronics
and are protected by trade secret, patent law or copyright law.
Dissemination of this information or reproduction of this material
is strictly forbidden unless prior written permission is obtained
from Delta Electronics.
*/
package com.fcf.security.blowser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fcf.security.blowser.service.MyUserDetailsService;
import com.fcf.security.core.properties.SecurityConstants;

/**
 * @author V.Caifeng.Fan
 * @ClassName BlowserSecurityConfig
 * @Description: TODO
 * @date 2020年3月27日 上午9:08:58
 */

@EnableWebSecurity
public class BlowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// super.configure(http);
		http.formLogin()
				.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)//需要认证时跳转的路径
				.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM) //登入操作执行的路径
			.and()
				.authorizeRequests()
				.antMatchers("/login",//进入登入页面的路径
						SecurityConstants.DEFAULT_UNAUTHENTICATION_URL).permitAll()// 表示除了登入页面还有需要认证跳转的路径, 其他的都需要认证才能访问

				.anyRequest()
				.authenticated()
			.and()
				.csrf().disable();//这个地方如果不禁用的话, 就会登入不成功

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// 先判断内存中有没有, 在判断数据库中的
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())//
				.withUser("itguang").password(new BCryptPasswordEncoder().encode("1234")).roles("USER")//
				.and()//
				.withUser("admin").password(new BCryptPasswordEncoder().encode("1234")).roles("ADMIN");//
		// 对客户端输入的密码手动加密, 如果配置了PasswordEncoder对象, 就不需要这个步骤加密
		// auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailService);
	}

	/**
	 * spring security5 , 默认会对客户端输入的密码加密后, 再跟数据库/内存中的密码进行比对. 加密的方法为:PasswordEncoder.encode(CharSequence rawPassword);
	 * 比对的方法为:PasswordEncoder.matches(CharSequence rawPassword, String encodedPassword) 所以我们需要配置加密的方式, 不然登入的时候, 密码会因为匹配不上, 导致登入失败, 报错302状态码,后台报错There is no
	 * PasswordEncoder mapped for the id "null"
	 *
	 * 注意: 注册时加密的方式要使用这个bean中的encode()方法, 加密和比对要一致
	 *
	 * @return
	 */
	@Bean
	// 一定要配置这个bean
	public PasswordEncoder passwordEncoder() {

		// 同一个密码, 每次生成的都不一样, 盐不一样
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		// TODO Auto-generated method stub
		super.configure(web);
	}
}
