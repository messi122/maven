package cn.comico.erp.commons.result;

public interface ResultCode {

    public static final String SUCCESS          = "000000";         //成功
    public static final String FAIL             = "000001";         //失败
    public static final String PARAM_ERROR      = "000002";         //参数不正确

    public static final String OBJECT_NOT_EXISTS            = "100001";        //对象不存在

    public static final String INVALID_TOKEN                = "200000";         //无效token

    public static final String BAD_REQUEST = "500400";                      //bad request
    public static final String UNAUTHORIZED = "500401";                  //UNAUTHORIZED
    public static final String FORBIDDEN = "500403";                    //FORBIDDEN
    public static final String NOT_FOUND = "500404";                    //NOT_FOUND
    public static final String METHOD_NOT_ALLOWED = "500405";           //METHOD_NOT_ALLOWED

    public static final String INTERNAL_SERVER_ERROR = "500500";        //系统错误500
    public static final String BAD_GATEWAY = "500502";                  //BAD_GATEWAY
    public static final String SERVICE_UNAVAILABLE = "500503";          //SERVICE_UNAVAILABLE
    public static final String GATEWAY_TIMEOUT = "500504";              //GATEWAY_TIMEOUT

}
