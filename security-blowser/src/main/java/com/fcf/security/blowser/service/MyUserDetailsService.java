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
package com.fcf.security.blowser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author V.Caifeng.Fan
 * @ClassName MyUserDetailsService
 * @Description: 这个类只负责到数据库中, 根据登入的用户名, 获取用户的密码和权限, 并返回, 不涉及认证和验权的校验
 *
 * @date 2020年3月27日 上午9:44:14
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

	/**
	 * username: 为前端页面用户输入的用户名
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("用户的登入名: " + username);
		// 根据用户名到数据库查找用户信息(密码和权限, 然后封装返回)
		// 这里我们假设用户的密码为"123", 权限为"admin", 因为注册的时候会对密码进行加密, 所以我们下面手动加密

		// 根据查找到的用户信息判断用户是否被冻结, 账户是否过期等, 根据判断的结果赋值给user对象
		boolean isAccountNonExpired = true; // 过期
		boolean isAccountNonLocked = true;// 被锁定
		return new User(username, new BCryptPasswordEncoder().encode("123"), true, isAccountNonExpired, true, isAccountNonLocked,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		// return new User(username, new BCryptPasswordEncoder().encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
