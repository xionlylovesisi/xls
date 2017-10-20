/**
 * 2017年10月20日
 */
package com.xlm.mvc.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XIXI
 *
 */
@Controller
public class SSEController {
	@RequestMapping(value="/push",produces = "text/event-stream")
	public @ResponseBody String push(){
		System.out.println(this.getClass().getName()+"--->[push]:**[INFO]**[push execute start]!");
		Random random = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getClass().getName()+"--->[push]:**[INFO]**[push execute end]!");
		return "data:Testing 1,2,3 "+random.nextInt()+"\n\n";
	}
}
