/**
 * 2017年10月19日
 */
package com.xlm.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xlm.mvc.domain.DemoObj;
import com.xlm.mvc.exception.AdviceTestException;

/**
 * 测试ControllerAdvice
 * @author XIXI
 *
 */
@Controller
public class AdviceController {
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg,DemoObj demoObj){
		throw new AdviceTestException("参数有误,来自@ModelAttribute msg:"+msg, this.getClass());
	}
}
