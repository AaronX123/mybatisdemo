package com.bosssoft.hr.train.response;

import java.io.Serializable;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-25
 */
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 3931555785168549018L;
    /**
     * 表明处理结果，success或fail
     */
    private String status;
    /**
     *
     */
    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 如果没有定义status则设置为success
     * @param data 返回给前端的json信息
     * @return CommonReturnType对象success
     */
    public static CommonResponse create(Object data){
        return CommonResponse.create(data,"success");
    }

    /**
     * 创建一个带有status的data包装类
     * @param data 返回给前端的json信息
     * @param status 状态码，success和fail
     * @return CommonReturnType对象
     */
    public static CommonResponse create(Object data, String status){
        CommonResponse commonResponse =new CommonResponse();
        commonResponse.setData(data);
        commonResponse.setStatus(status);
        return commonResponse;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
