package com.hm.springreact.util;

import com.hm.springreact.exception.CommonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public abstract class Jsons {
    public static final TypeReference<Map<String, String>> TYPE_MAP_STRING_STRING = new TypeReference<>() {};
    public static final TypeReference<Map<String, Object>> TYPE_MAP_STRING_OBJECT = new TypeReference<>() {};
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    private Jsons() {
    }

    public static void writeValue(OutputStream out, Object value) {
        try {
            mapper.writeValue(out, value);
        } catch (IOException e) {
            // Don't worry may be fine...
            throw new CommonException(e);
        }
    }

    public static String writeValueAsString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            // Don't worry may be fine....
            throw new CommonException(e);
        }
    }

    public static <T> T readValue(String value, Class<T> valueType) {
        try {
            return mapper.readValue(value, valueType);
        } catch (JsonProcessingException e) {
            // Don't worry may be fine....
            throw new CommonException(e);
        }
    }

    public static <T> T readValue(InputStream value, Class<T> valueType) {
        try {
            return mapper.readValue(value, valueType);
        } catch (IOException e) {
            // Don't worry may be fine....
            throw new CommonException(e);
        }
    }

    public static Map<String, String> readValueAsMap(String value) {
        try {
            return mapper.readValue(value, TYPE_MAP_STRING_STRING);
        } catch (JsonProcessingException e) {
            // Don't worry may be fine....
            throw new CommonException(e);
        }
    }

    public static Map<String, Object> readValueAsMap(InputStream value) {
        try {
            return mapper.readValue(value, TYPE_MAP_STRING_OBJECT);
        } catch (IOException e) {
            // Don't worry may be fine....
            throw new CommonException(e);
        }
    }
}
