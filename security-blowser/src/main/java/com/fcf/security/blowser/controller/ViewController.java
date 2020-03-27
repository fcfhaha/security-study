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
package com.fcf.security.blowser.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fcf.security.blowser.surport.SimpleResponse;
import com.fcf.security.core.properties.SecurityConstants;

/**
 * @author V.Caifeng.Fan
 * @ClassName ViewCOntroller
 * @Description: 需要身份认证时跳转到这里
 * @date 2020年3月27日 上午9:28:04
 */
@Controller
public class ViewController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private SecurityProperties securityProperties;
	/**
	 * 当需要身份认证时，跳转到这里
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("引发跳转的请求是:" + targetUrl);
			if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				redirectStrategy.sendRedirect(request, response, "/login");
			}
		}

		return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
	}

	@RequestMapping("/login")
	public String index() {

		return "demo-signIn";

	}
}
