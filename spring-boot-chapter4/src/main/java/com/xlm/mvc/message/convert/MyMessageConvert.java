/**
 * 2017年10月20日
 */
package com.xlm.mvc.message.convert;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.xlm.mvc.domain.DemoObj;

/**
 * @author XIXI
 *
 */
public class MyMessageConvert extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConvert() {
		super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
	}
	/* (non-Javadoc)
	 * @see org.springframework.http.converter.AbstractHttpMessageConverter#supports(java.lang.Class)
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		System.out.println(this.getClass().getName()+"--->[supports]:**[INFO]**[supports execute]!");
		return DemoObj.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.http.converter.AbstractHttpMessageConverter#readInternal(java.lang.Class, org.springframework.http.HttpInputMessage)
	 */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println(this.getClass().getName()+"--->[readInternal]:**[INFO]**[readInternal execute start]!");
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		System.out.println(this.getClass().getName()+"--->[readInternal]:**[INFO]**[readInternal request body:"+temp+"]!");
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}

	/* (non-Javadoc)
	 * @see org.springframework.http.converter.AbstractHttpMessageConverter#writeInternal(java.lang.Object, org.springframework.http.HttpOutputMessage)
	 */
	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello:"+t.getId()+"-"+t.getName();
		System.out.println(this.getClass().getName()+"--->[writeInternal]:**[INFO]**[writeInternal response body:"+out+"]!");
		outputMessage.getBody().write(out.getBytes());
	}

}
