/**
 * 2017年9月29日
 */
package com.xlm.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author XIXI
 *
 */
public class MyX509TrustManager implements X509TrustManager,TrustManager {

	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#checkClientTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkClientTrusted(X509Certificate[] X509Certificates, String arg1) throws CertificateException {
		System.out.println("checkClientTrusted--->X509Certificates"+X509Certificates+"arg1"+arg1);
	}

	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] X509Certificate, String arg1) throws CertificateException {
		System.out.println("checkServerTrusted--->X509Certificate:"+X509Certificate+"arg1:"+arg1);

	}

	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

}
