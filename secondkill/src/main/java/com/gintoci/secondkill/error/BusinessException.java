package com.gintoci.secondkill.error;

/**
 * @Classname BusinessException
 * @Description TODO
 * @Date 2020-03-04 10:33
 * @Created by gin
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收EmBusinessError中的传参用于构造业务异常
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //自定义errMeg来构造业务异常
     public BusinessException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        commonError.setErrMsg(errMsg);
     }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
