package com.bosssoft.hr.train.request;

import java.io.Serializable;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-27
 */
public class CommonRequest implements Serializable {
    private static final long serialVersionUID = -6251095782279645317L;
    /**
     * 请求的路径
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求的数据
     */
    Object data;

    public CommonRequest() {
    }

    public CommonRequest(String url, String method, Object data) {
        this.url = url;
        this.method = method;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                '}';
    }
}
