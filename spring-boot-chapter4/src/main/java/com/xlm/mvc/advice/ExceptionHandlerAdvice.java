/**
 * 2017年10月19日
 */
package com.xlm.mvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xlm.mvc.exception.AdviceTestException;

/**
 * @author XIXI
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(AdviceTestException.class)
	public ModelAndView exception(Exception exception,WebRequest webRequest){
		AdviceTestException adviceTestException = (AdviceTestException) exception;
		System.out.println(adviceTestException.getExceptionClass().getName()+" happen exception, exception message:"+adviceTestException.getMessage());
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage",adviceTestException.getMessage());
		modelAndView.addObject("errorClass",adviceTestException.getExceptionClass().getName());
		return modelAndView;
	}
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外信息");
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id");
	}
}
