//package com.bachelor.bachelor.config.data;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//
//import javax.validation.Validator;
//
//@Configuration
//public class ValidationConfiguration extends ValidatingMongoEventListener {
//
//    public ValidationConfiguration(Validator validator) {
//        super(validator);
//    }
//
//    @Bean
//    public ValidatingMongoEventListener validatingMongoEventListener() {
//        return new ValidatingMongoEventListener(validator());
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean validator() {
//        return new LocalValidatorFactoryBean();
//    }
//}
