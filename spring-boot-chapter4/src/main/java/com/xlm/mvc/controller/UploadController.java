/**
 * 2017年10月19日
 */
package com.xlm.mvc.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XIXI
 *
 */
@Controller
public class UploadController {
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile multipartFile){
		try{
			FileUtils.writeByteArrayToFile(new File("D:/temp/"+multipartFile.getOriginalFilename()), multipartFile.getBytes());
			return "ok";
		}catch(Exception e){
			System.out.println(this.getClass().getName()+"--->[upload]:**[ERROR]**[error message:"+e+"]!");
			return "wrong";
		}
	}
}
