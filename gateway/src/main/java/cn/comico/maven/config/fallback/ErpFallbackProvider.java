package cn.comico.maven.config.fallback;

import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.erp.commons.result.ResultCode;
import cn.comico.supply.erp.commons.result.ResultResp;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ErpFallbackProvider
 * @Description TODO    网关熔断器
 * @date 2018/7/30 19:42
 **/
@Component
public class ErpFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream(ResultResp.code(ResultCode.INTERNAL_SERVER_ERROR)
//                        .message("INTERNAL_SERVER_ERROR")
//                        .build()
//                        .json()
//                        .getBytes());
                return new ByteArrayInputStream(ResultResp.code(ResultCode.NOT_FOUND)
                        .message("NOT_FOUND")
                        .build()
                        .json()
                        .getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
