package com.hm.springreact.util;


import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.time.Instant;

public abstract class Beans {
    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.addConverter(new AbstractConverter<String, Instant>() {
            @Override
            protected Instant convert(String source) {
                return Strings.isEmpty(source) ? null : Instant.parse(source);
            }
        });
        mapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private Beans() {
    }

    public static void copyProperties(Object dest, Object src) {
        mapper.map(src, dest);
    }

    public static <T> T clone(Object src, Class<T> type) {
        return mapper.map(src, type);
    }

    public static <T> T clone(Object src, Type type) {
        return mapper.map(src, type);
    }


}
