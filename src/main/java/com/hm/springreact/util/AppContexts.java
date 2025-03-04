package com.hm.springreact.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

public class AppContexts implements ApplicationContextAware {
    private static ApplicationContext INSTANCE;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        INSTANCE = applicationContext;
    }

    public static <T> T getBean(Class<T> type) {
        return INSTANCE.getBean(type);
    }
}
