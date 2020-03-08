package com.gintoci.secondkill.error;

/**
 * @Classname CommonError
 * @Description TODO
 * @Date 2020-03-04 10:22
 * @Created by gin
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
