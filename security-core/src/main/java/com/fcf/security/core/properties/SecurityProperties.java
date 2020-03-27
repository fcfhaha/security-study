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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author V.Caifeng.Fan
 * @ClassName SecurityProperties
 * @Description: TODO
 * @date 2020年3月27日 下午4:44:49
 */
@ConfigurationProperties("fcf.security")
public class SecurityProperties {
	private BlowserProperties blowser;
	private AppProperties app;

	/**
	 * @return the blowser
	 */
	public BlowserProperties getBlowser() {

		return blowser;
	}

	/**
	 * @param blowser the blowser to set
	 */
	public void setBlowser(BlowserProperties blowser) {

		this.blowser = blowser;
	}

	/**
	 * @return the app
	 */
	public AppProperties getApp() {

		return app;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(AppProperties app) {

		this.app = app;
	}


}
