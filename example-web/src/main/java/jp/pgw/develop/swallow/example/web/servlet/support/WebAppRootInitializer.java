package jp.pgw.develop.swallow.example.web.servlet.support;

import jp.pgw.develop.swallow.example.config.AppConfig;
import jp.pgw.develop.swallow.example.config.SecurityConfig;
import jp.pgw.develop.swallow.example.persistence.PersistenceConfig;
import jp.pgw.develop.swallow.example.service.ServiceConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.*;

/**
 * Created by kazamage on 2015/06/28.
 */
@Order(2)
public class WebAppRootInitializer extends AbstractContextLoaderInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(new Class[]{AppConfig.class, SecurityConfig.class, ServiceConfig.class, PersistenceConfig.class});
        return rootAppContext;
    }

}
