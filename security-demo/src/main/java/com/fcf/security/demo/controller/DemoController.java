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
package com.fcf.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author V.Caifeng.Fan
 * @ClassName DemoController
 * @Description: TODO
 * @date 2020年3月27日 上午9:17:12
 */
@RestController
public class DemoController {

	/**
	 *
	 */
	@GetMapping("hello")
	public String hello() {

		return "hello";
	}

}
