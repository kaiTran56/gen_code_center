package com.xfilter.tech.configs;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

public class AppContextCenter implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
    public static Object getBean(String beanName){
        return CONTEXT.getBean(beanName);
    }

    public static String getMessage(String key, Locale locale, Object ... obj){
        MessageUtils messageUtils = (MessageUtils) AppContextCenter.getBean("messageUtils");
        String content  = messageUtils.getMessage(key, locale, obj);
        return content;
    }
}
