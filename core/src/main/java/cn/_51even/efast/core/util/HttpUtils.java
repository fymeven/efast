package cn._51even.efast.core.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/18.
 */

/**
 * http请求
 */
public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static final RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).setConnectionRequestTimeout(10000).build();

    private static final String CHARSET="UTF-8";

    static class ContentType{
        private static final String X_WWW_FORM_URLENCODED="application/x_www_form_urlencoded";
        private static final String MULTIPART_FORM_DATA="multipart_form_data";
        private static final String APPLICATION_JSON="application/json;charset=utf-8";
    }

    public static <T>T doPost(String url,JSONObject param,Class<T> beanClass){
        return doPost(url,param,null,null,null,beanClass);
    }

    public static <T>T doPost(String url,JSONObject param,JSONObject header,Class<T> beanClass){
        return doPost(url,param,header,null,null,beanClass);
    }

    public static <T>T doPost(String url,JSONObject param,JSONObject header,JSONObject file,String contentType,Class<T> beanClass){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        try {
            if (StringUtils.isBlank(url)){
                logger.info("http post请求url为空");
                return null;
            }
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            if (param != null && !param.isEmpty()){
                switch (contentType){
                    case ContentType.X_WWW_FORM_URLENCODED:
                    default:
                        List<NameValuePair> pairs = new ArrayList<>(param.size());
                        for (Map.Entry<String, Object> entry : param.entrySet()) {
                            if (entry.getValue() != null){
                                pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue().toString()));
                            }
                        }
                        break;
                    case ContentType.APPLICATION_JSON:
                        StringEntity stringEntity = new StringEntity(param.toJSONString(),CHARSET);
                        stringEntity.setContentEncoding(CHARSET);
                        stringEntity.setContentType(contentType);
                        httpPost.setEntity(stringEntity);
                        break;
                    case ContentType.MULTIPART_FORM_DATA:
                        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                        multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                        multipartEntityBuilder.setCharset(Charset.forName(CHARSET));
                        for (Map.Entry<String, Object> entry : param.entrySet()) {
                            if (entry.getValue() != null){
                                multipartEntityBuilder.addPart(entry.getKey(),new StringBody(entry.getValue().toString(), org.apache.http.entity.ContentType.TEXT_PLAIN));
                            }
                        }
                        if (file != null && !file.isEmpty()){
                            for (Map.Entry<String, Object> entry : file.entrySet()) {
                                multipartEntityBuilder.addBinaryBody(entry.getKey(),(InputStream)entry.getValue());
                            }
                        }
                        HttpEntity httpEntity = multipartEntityBuilder.build();
                        httpPost.setEntity(httpEntity);
                        break;
                }
            }
            if (header != null && !header.isEmpty()){
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    httpPost.setHeader(entry.getKey(),entry.getValue().toString());
                }
            }
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String str = EntityUtils.toString(response.getEntity(),"UTF-8");
                T bean = beanClass.newInstance();
                if (bean instanceof JSONObject){
                    return (T)JSONObject.parseObject(str);
                }else if (bean instanceof JSONArray){
                    return (T)JSONArray.parse(str);
                }else {
                    return (T)str;
                }
            }
        }catch (Exception e){
            logger.error("http post请求出错:"+url,e);
        }finally {
            try {
                if (response!=null){
                    response.close();
                }
                httpPost.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                logger.error("资源关闭发生错误"+e);
            }
        }
        return null;
    }

    public static <T>T doGet(String url,JSONObject param,JSONObject header,Class<T> beanClass){
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        try {
            if (StringUtils.isBlank(url)){
                logger.info("http get请求url为空");
                return null;
            }
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            if (param != null && !param.isEmpty()){
                List<NameValuePair> pairs = new ArrayList<>(param.size());
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    if (entry.getValue() != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue().toString()));
                    }
                }
                url +="?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs,CHARSET));
            }
            if (header != null && !header.isEmpty()){
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    httpGet.setHeader(entry.getKey(),entry.getValue().toString());
                }
            }
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String str = EntityUtils.toString(response.getEntity(),CHARSET);
                T bean = beanClass.newInstance();
                if (bean instanceof JSONObject){
                    return (T)JSONObject.parseObject(str);
                }else if (bean instanceof JSONArray){
                    return (T)JSONArray.parse(str);
                }else {
                    return (T)str;
                }
            }
        }catch (Exception e){
            logger.error("http get请求出错:"+url,e);
        }finally {
            try {
                if (response!=null){
                    response.close();
                }
                httpGet.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                logger.error("资源关闭发生错误"+e);
            }
        }
        return null;
    }

}
