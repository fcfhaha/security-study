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
package com.fcf.security.core.properties;


/**
 * @author V.Caifeng.Fan
 * @ClassName SecurityConstants
 * @Description: TODO
 * @date 2020年3月27日 下午4:36:09
 */
public interface SecurityConstants {

	/**
	 * 当请求需要身份认证时，默认跳转的url
	 *
	 * @see SecurityController
	 */
	public static final String DEFAULT_UNAUTHENTICATION_URL = "/login/required";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
	/**
	 * 默认进入访问登入页面的url
	 */
	public static final String DEFAULT_LOGIN_PAGE_URL = "/login";



}
