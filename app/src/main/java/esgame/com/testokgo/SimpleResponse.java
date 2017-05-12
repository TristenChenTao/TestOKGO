package esgame.com.testokgo;

import java.io.Serializable;

public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int ResultCode;
    public String ResultMessage;

    public BaseResponse toBaseResponse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.ResultCode = ResultCode;
        baseResponse.ResultMessage = ResultMessage;
        return baseResponse;
    }
}