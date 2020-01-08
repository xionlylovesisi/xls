/**
 * 2017年10月20日
 */
package com.xlm.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlm.mvc.domain.DemoObj;

/**
 * http message converter test
 * @author XIXI
 *
 */
@Controller
public class ConverterController {
	@RequestMapping(value="/convert",produces="application/x-wisely")
	@ResponseBody
	public DemoObj converter(@RequestBody DemoObj demoObj){
		return demoObj;
	}
}
