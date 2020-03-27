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
package com.fcf.security.blowser.surport;


/**
 * @author V.Caifeng.Fan
 * @ClassName SimpleResponse
 * @Description: TODO
 * @date 2020年3月27日 下午4:39:51
 */
public class SimpleResponse {

	private Object content;


	/**
	 * @return the content
	 */
	public Object getContent() {

		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(Object content) {

		this.content = content;
	}


	/**
	 * @param content
	 */
	public SimpleResponse(Object content) {

		super();
		this.content = content;
	}


}
