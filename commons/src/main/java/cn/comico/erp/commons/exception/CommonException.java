package cn.comico.erp.commons.exception;


import cn.comico.erp.commons.result.ResultResp;

public class CommonException extends RuntimeException{

    public CommonException(String code, String message) {
        super(ResultResp.code(code).message(message).build().json());
    }

}
