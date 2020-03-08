package com.gintoci.secondkill.response;

/**
 * @Classname CommonReturnType
 * @Description TODO
 * @Date 2020-03-04 10:09
 * @Created by gin
 */
public class CommonReturnType {
//    表明对应请求返回的处理结果 success or fail
    private String status;

//    若status返回success则data返回前端正确的json数据
//    若status返回fail则data返回前端通用的错误码格式
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
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
}
