package cn.comico.erp.commons.result;

public class ResultRespBuilder<T> {

    private String code;

    private String message;

    private T t;

    public ResultRespBuilder() {

    }

    public ResultResp<T> build() {
        ResultResp<T> resultResp = new ResultResp<>();
        resultResp.setCode(code);
        resultResp.setMessage(null != message ? message : "");
        resultResp.setData(t);
        return resultResp;
    }

    public ResultRespBuilder code(String code) {
        this.code = code;
        return this;
    }

    public ResultRespBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ResultRespBuilder data(T t) {
        this.t = t;
        return this;
    }

}
