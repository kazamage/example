package jp.pgw.develop.swallow.example.rest.api.v1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by kazamage on 2015/06/28.
 */
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableSpringDataWebSupport
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class RestApiV1Config extends WebMvcConfigurerAdapter {
}
