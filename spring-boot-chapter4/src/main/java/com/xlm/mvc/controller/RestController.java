/**
 * 2017年10月20日
 */
package com.xlm.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlm.mvc.service.DemoService;

/**
 * @author XIXI
 *
 */
@Controller
public class RestController {

	@Autowired
	private DemoService demoService;
	@RequestMapping(value="/testRest",produces="text/plain;charset=UTF-8")
	public @ResponseBody String testRest(){
		return demoService.saySomething();
	}
}
