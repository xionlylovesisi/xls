/**
 * 2017年9月26日
 */
package com.xlm.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author XIXI
 *
 */
public class MyHostnameVerifier implements HostnameVerifier {

	/* (non-Javadoc)
	 * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String, javax.net.ssl.SSLSession)
	 */
	@Override
	public boolean verify(String hostname, SSLSession session) {
		System.out.println("MyHostnameVerifier--->verify--->hostname"+hostname+",session:"+session);
		System.out.println(hostname);
		if("localhost".equals(hostname)){  
            return true;  
        } else {  
            return false;  
        }  
	}

}
