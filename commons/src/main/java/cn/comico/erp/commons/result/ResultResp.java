package cn.comico.erp.commons.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

/**
 * 通用返回结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResp<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultResp() {
    }

    public static ResultRespBuilder code(String code) {
        ResultRespBuilder resultRespBuilder = new ResultRespBuilder();
        return resultRespBuilder.code(code);
    }

    public static ResultRespBuilder message(String message) {
        ResultRespBuilder resultRespBuilder = new ResultRespBuilder();
        return resultRespBuilder.message(message);
    }

    public static <T> ResultRespBuilder<T> data(T t) {
        ResultRespBuilder resultRespBuilder = new ResultRespBuilder();
        return resultRespBuilder.data(t);
    }

    public String json() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.getCode().equals(ResultCode.SUCCESS);
    }

    public static void main(String[] args) {
        ResultResp resultResp = ResultResp.code(ResultCode.SUCCESS).message("success").build();
        System.out.println(resultResp.json());
    }
}
