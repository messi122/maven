package cn.comico.maven.config.filter;

import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultRespBuilder;
import cn.comico.supply.erp.commons.result.ResultCode;
import cn.comico.supply.erp.commons.result.ResultRespBuilder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PostFilter
 * @Description TODO 后置网关过滤器
 * @date 2018/7/9 15:19
 **/
@Component
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        int statusCode = requestContext.getResponseStatusCode();
        if (HttpStatus.OK.value() != statusCode && statusCode != HttpStatus.UNAUTHORIZED.value()) {
            setResponseResult(statusCode, requestContext);
            requestContext.setResponseStatusCode(HttpStatus.OK.value());
            requestContext.setSendZuulResponse(false);
        }
        return null;
    }

    private void setResponseResult(int statusCode, RequestContext requestContext) {
        ResultRespBuilder builder = new ResultRespBuilder();
        switch (statusCode) {
            case 400:
                builder.code(ResultCode.BAD_REQUEST).message(HttpStatus.BAD_REQUEST.getReasonPhrase());
                break;
            case 401:
                builder.code(ResultCode.UNAUTHORIZED).message(HttpStatus.UNAUTHORIZED.getReasonPhrase());
                break;
            case 403:
                builder.code(ResultCode.FORBIDDEN).message(HttpStatus.FORBIDDEN.getReasonPhrase());
                break;
            case 404:
                builder.code(ResultCode.NOT_FOUND).message(HttpStatus.NOT_FOUND.getReasonPhrase());
                break;
            case 500:
                builder.code(ResultCode.INTERNAL_SERVER_ERROR).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                break;
            case 502:
                builder.code(ResultCode.BAD_GATEWAY).message(HttpStatus.BAD_GATEWAY.getReasonPhrase());
                break;
            case 503:
                builder.code(ResultCode.SERVICE_UNAVAILABLE).message(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
                break;
            case 504:
                builder.code(ResultCode.GATEWAY_TIMEOUT).message(HttpStatus.GATEWAY_TIMEOUT.getReasonPhrase());
                break;
            default:
                builder.code(ResultCode.INTERNAL_SERVER_ERROR).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                break;
        }
        requestContext.setResponseBody(builder.build().json());
//        requestContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestContext.addZuulResponseHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    }
}
