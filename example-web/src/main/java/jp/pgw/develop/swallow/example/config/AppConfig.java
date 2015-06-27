package jp.pgw.develop.swallow.example.config;

import jp.pgw.develop.swallow.example.persistence.PersistenceConfig;
import jp.pgw.develop.swallow.example.service.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by kazamage on 2015/06/28.
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
