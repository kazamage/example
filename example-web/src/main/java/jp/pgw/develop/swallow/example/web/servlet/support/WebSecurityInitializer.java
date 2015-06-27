package jp.pgw.develop.swallow.example.web.servlet.support;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

/**
 * Created by kazamage on 2015/06/28.
 */
@Order(1)
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        super.beforeSpringSecurityFilterChain(servletContext);
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC), false, "/*");
    }

}
