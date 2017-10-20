/**
 * 2017年10月20日
 */
package com.xlm.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xlm.mvc.service.DemoService;

/**
 * @author XIXI
 *
 */
@Controller
public class NormalController {
	@Autowired
	private DemoService demoService;
	@RequestMapping("/normal")
	public String testPage(Model model){
		model.addAttribute("msg",demoService.saySomething());
		return "page";
	}
}
