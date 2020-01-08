/**
 * 2017年9月26日
 */
package com.xlm.ssl;

/**
 * @author XIXI
 *
 */
public class TestSSL {
	public static void main(String[] args) throws Exception {
		// 密码  
        String password = "12345";  
        // 密钥库  
        String keyStorePath = "D:\\za_mcx\\project\\hengqin\\ssl\\server.crt";  
        // 信任库  
        String trustStorePath = "D:\\za_mcx\\project\\hengqin\\ssl\\server.crt";  
        // 本地起的https服务  
        String httpsUrl = "https://localhost/";  
        // 传输文本  
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><fruitShop><fruits><fruit>&lt;kind>萝卜</kind></fruit><fruit><kind>菠萝</kind></fruit></fruits></fruitShop>";  
        HttpsPost.initHttpsURLConnection(password, keyStorePath, trustStorePath);  
        // 发起请求  
        HttpsPost.post(httpsUrl, xmlStr);  
	}
}
