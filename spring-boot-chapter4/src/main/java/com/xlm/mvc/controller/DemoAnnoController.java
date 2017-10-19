/**
 * 2017年10月19日
 */
package com.xlm.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlm.mvc.domain.DemoObj;

/**
 * 演示各种方式的请求
 * @author XIXI
 *
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request){
		return "url:"+request.getRequestURL()+" can access";
	}
	@RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(HttpServletRequest request,@PathVariable String str){
		return "url:"+request.getRequestURL()+" can access,str:"+str;
	}
	@RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(HttpServletRequest request,Long id){
		return "url:"+request.getRequestURL()+" can access,id:"+id;
	}
	@RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  String passObj(HttpServletRequest request,DemoObj obj){
		return "url:"+request.getRequestURL()+" can access,obj id:"+obj.getId()+",name:"+obj.getName();
	}
	@RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
	
	public @ResponseBody String names(HttpServletRequest request){
		return "url:"+request.getRequestURL()+" can access";
	}
}
