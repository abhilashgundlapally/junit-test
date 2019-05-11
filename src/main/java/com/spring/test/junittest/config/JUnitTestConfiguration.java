package com.spring.test.junittest.config;

import com.spring.test.junittest.controllers.HelloController;
import com.spring.test.junittest.controllers.ItemsController;
import com.spring.test.junittest.respository.ItemsRepository;
import com.spring.test.junittest.services.ItemsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackageClasses = {com.spring.test.junittest.respository.ItemsRepository.class})
public class JUnitTestConfiguration {


//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.H2)
//                .addScript("data-h2.sql")
//                .build();
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.spring.test.junittest.model");
//        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }

    @Bean("HelloController")
    public HelloController getHelloController(){
        return new HelloController();
    }

    @Bean("ItemsService")
    public ItemsService getItemsService(ItemsRepository repository){
        return new ItemsService(repository);
    }

    @Bean("ItemsController")
    public ItemsController getItemsController(ItemsService service){
        return new ItemsController(service);
    }

}
