package jp.pgw.develop.swallow.example.web.servlet.support;

import jp.pgw.develop.swallow.example.rest.api.v1.RestApiV1Config;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by kazamage on 2015/06/28.
 */
@Order(3)
public class RestApiV1Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RestApiV1Config.class};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/v1/*"};
    }

}
