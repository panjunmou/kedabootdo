package com.kedacom.kedabootdo.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

/**
 * Webservice的动态client, 使用缓存保存client实例.
 */
public class WebServiceClient {
    
    private static final Logger logger = LoggerFactory.getLogger(WebServiceClient.class);
    
    /**
     * 所有的调用
     */
    private static Hashtable<String, Client> CLIENT_MAP = new Hashtable<String, Client>();

    /**
     * 调用外系统webservice.
     * @param url 外系统webservice的url
     * @param method 外系统的方法
     * @param parameter 外系统需要的数据，返回给外系统使用
     * @throws Exception
     */
    public static String invoke(String url, String method, Object... parameter) throws Exception {
        Object[] result;
        try {
            Client client = CLIENT_MAP.get(url);
            if (client == null){
                JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
                client = dcf.createClient(url);
                CLIENT_MAP.put(url, client);
            }

            result = client.invoke(method, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(url + "," + method, e);
            throw e;
        }
        if (result == null || result.length == 0){
            return null;
        }
        if (null == result[0]){
            return null;
        }
        
        return result[0].toString();
    }

}
