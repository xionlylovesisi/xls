/**
 * 2017年10月18日
 */
package com.xlm.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XIXI
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}
}
