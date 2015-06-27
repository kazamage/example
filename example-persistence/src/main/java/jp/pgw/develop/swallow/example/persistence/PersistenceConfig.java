package jp.pgw.develop.swallow.example.persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.weblogic.WebLogicLoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * Created by kazamage on 2015/06/28.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig {

    @Inject
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        final EmbeddedDatabaseType embeddedDatabaseType = EmbeddedDatabaseType.valueOf(env.getProperty("persistence.embeddedDatabaseType", "H2"));
        builder.setType(embeddedDatabaseType);
        final String initScripts = env.getProperty("persistence.init.scripts");
        if (!StringUtils.isEmpty(initScripts)) {
            builder.addScripts(initScripts.split(","));
        }
        return builder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setDataSource(dataSource());
        final String persistenceUnitName = env.getProperty("persistence.jpa.persistenceUnitName", "example");
        factory.setPersistenceUnitName(persistenceUnitName);
        final String packagesToScan = env.getProperty("persistence.jpa.packagesToScan");
        Objects.requireNonNull(packagesToScan);
        factory.setPackagesToScan(packagesToScan.split(","));
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        final String databasePlatform = env.getProperty("persistence.jpa.databasePlatform");
        Objects.requireNonNull(databasePlatform);
        vendorAdapter.setDatabasePlatform(databasePlatform);
        final boolean generateDdl = env.getProperty("persistence.jpa.generateDdl", Boolean.class, false);
        vendorAdapter.setGenerateDdl(generateDdl);
        final boolean showSql = env.getProperty("ersistence.jpa.showSql", Boolean.class, false);
        vendorAdapter.setShowSql(showSql);
        factory.setJpaVendorAdapter(vendorAdapter);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
