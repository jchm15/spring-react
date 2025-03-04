package com.hm.springreact.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Objects;

public class Messages implements MessageSourceAware {
    private static MessageSource INSTANCE;
    private static LocaleResolver RESOLVER;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        INSTANCE = messageSource;
    }

    public void setLocaleResolver(LocaleResolver localeResolver) {
        RESOLVER = localeResolver;
    }

    public static String getMessage(String code) {
        return INSTANCE.getMessage(code, null, RESOLVER.resolveLocale(getHttpServletRequest()));
    }

    public static String getMessage(String code, String... args) {
        return INSTANCE.getMessage(code, args, RESOLVER.resolveLocale(getHttpServletRequest()));
    }

    public static String getMessage(String code, List<String>  args) {
        return INSTANCE.getMessage(code, args.toArray(), RESOLVER.resolveLocale(getHttpServletRequest()));
    }

    private static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
