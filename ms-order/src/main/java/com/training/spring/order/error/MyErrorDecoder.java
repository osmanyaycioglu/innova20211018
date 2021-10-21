package com.training.spring.order.error;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class MyErrorDecoder implements ErrorDecoder {

    private static final Logger logger = LoggerFactory.getLogger(MyErrorDecoder.class);


    @Override
    public RestClientException decode(final String methodKeyParam,
                                      final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                        ErrorObj.class);
            return new RestClientException(readValueLoc);
        } catch (Exception eLoc) {
            MyErrorDecoder.logger.error("[MyErrorDecoder][decode]-> *Error* : " + eLoc.getMessage(),
                                        eLoc);
        }
        return new RestClientException();
    }

}
