package com.xfilter.tech.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;
@Component("messageUtils")
public class MessageUtils {

    @Autowired
    private MessageSource messageSource;

    @Bean("messageSourceTemp")
    private MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        return messageSource;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("msg/messages"); // base name of the resource bundle
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        source.setCacheSeconds(3600); // Refresh cache once every hour
        return source;
    }

    public String getMessage(String key, Locale locale, Object... args) {
        Locale opt = Optional.ofNullable(locale).orElse(Locale.getDefault());
        return messageSource.getMessage(key, args, opt);
    }
}
