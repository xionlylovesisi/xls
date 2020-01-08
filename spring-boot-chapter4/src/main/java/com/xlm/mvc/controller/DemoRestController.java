/**
 * 2017年10月19日
 */
package com.xlm.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlm.mvc.domain.DemoObj;

/**
 * rest风格的请求
 * @author XIXI
 *
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
	@RequestMapping(value="/getjson",produces="application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
	@RequestMapping(value="/getxml",produces="application/xml;charset=UTF-8")
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
}
