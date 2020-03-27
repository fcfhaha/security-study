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
 * @ClassName BlowserProperties
 * @Description: TODO
 * @date 2020年3月27日 下午4:45:32
 */

public class BlowserProperties {

	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;


	/**
	 * @return the loginPage
	 */
	public String getLoginPage() {

		return loginPage;
	}


	/**
	 * @param loginPage the loginPage to set
	 */
	public void setLoginPage(String loginPage) {

		this.loginPage = loginPage;
	}

}
