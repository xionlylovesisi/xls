/**
 * 2017年10月20日
 */
package com.xlm.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.xlm.mvc.service.PushService;

/**
 * @author XIXI
 *
 */
@Controller
public class AsyncController {
	@Autowired
	private PushService pushService;
	@RequestMapping("/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
}
