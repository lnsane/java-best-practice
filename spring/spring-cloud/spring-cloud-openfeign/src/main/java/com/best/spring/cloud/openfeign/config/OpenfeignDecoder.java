package com.best.spring.cloud.openfeign.config;

import com.google.gson.Gson;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

/**
 * @author CunLu Wang
 * @since 2023/5/24
 */
@Slf4j
public class OpenfeignDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        byte[] bodyData = Util.toByteArray(response.body().asInputStream());
        log.info("Feign 响应. 状态码: {}, 响应体: {}", response.status(), response.charset().newDecoder().decode(ByteBuffer.wrap(bodyData)));
        String typeName = type.getTypeName();
        try {
            Class<?> clazz = Class.forName(getClassName(typeName));
            return new Gson().fromJson(response.charset().newDecoder().decode(ByteBuffer.wrap(bodyData)).toString(),clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getClassName(String className) {
        int index = className.indexOf('<');
        return index == -1 ? className : className.substring(0, index);
    }
}