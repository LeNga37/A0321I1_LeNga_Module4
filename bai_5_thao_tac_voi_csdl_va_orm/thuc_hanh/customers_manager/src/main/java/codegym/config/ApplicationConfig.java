//package codegym.config;
//
////import org.springframework.beans.BeansException;
////import org.springframework.beans.factory.annotation.Qualifier;
////import org.springframework.context.ApplicationContext;
////import org.springframework.context.ApplicationContextAware;
////import org.springframework.context.MessageSource;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.context.support.ResourceBundleMessageSource;
////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
////import org.springframework.jdbc.datasource.DriverManagerDataSource;
////import org.springframework.orm.jpa.JpaTransactionManager;
////import org.springframework.orm.jpa.JpaVendorAdapter;
////import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
////import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
////import org.springframework.transaction.PlatformTransactionManager;
////import org.springframework.transaction.annotation.EnableTransactionManagement;
////import org.springframework.web.servlet.config.annotation.EnableWebMvc;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
////import org.thymeleaf.TemplateEngine;
//////import org.thymeleaf.spring5.ISpringTemplateEngine;
//////import org.thymeleaf.spring5.SpringTemplateEngine;
//////import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//////import org.thymeleaf.spring5.view.ThymeleafViewResolver;
////import org.thymeleaf.spring4.ISpringTemplateEngine;
////import org.thymeleaf.spring4.SpringTemplateEngine;
////import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
////import org.thymeleaf.spring4.view.ThymeleafViewResolver;
////import org.thymeleaf.templatemode.TemplateMode;
////
////import javax.persistence.EntityManager;
////import javax.persistence.EntityManagerFactory;
////import java.util.Properties;
////
////@Configuration
////@EnableWebMvc
////@EnableTransactionManagement
////@EnableJpaRepositories("codegym.repository")
////@ComponentScan("codegym")
////public class AppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
////    private ApplicationContext applicationContext;
////
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        this.applicationContext = applicationContext;
////    }
////
////    //Thymeleaf Configuration
////    @Bean
////    public SpringResourceTemplateResolver templateResolver() {
////        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
////        templateResolver.setApplicationContext(applicationContext);
////        templateResolver.setPrefix("/views/thymeleaf/");
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode(TemplateMode.HTML);
////        templateResolver.setCharacterEncoding("UTF-8");
////        return templateResolver;
////    }
////
////    @Bean
////    public TemplateEngine templateEngine() {
////        TemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        return templateEngine;
////    }
////
////    @Bean
////    public ThymeleafViewResolver viewResolver() {
////        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
////        viewResolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
////        viewResolver.setCharacterEncoding("UTF-8");
////        return viewResolver;
////    }
//////     Config for jsp
//////    @Bean
//////    public InternalResourceViewResolver viewResolver() {
//////        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//////        viewResolver.setPrefix("/views/");
//////        viewResolver.setSuffix(".jsp");
//////        return viewResolver;
//////    }
////
////    @Bean
////    public MessageSource messageSource() {
////        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
////        messageSource.setBasenames("message");
////        messageSource.setDefaultEncoding("UTF-8");
////        return messageSource;
////    }
////
////    // Config hibernate
////    // Step 1: config datasource (thông tin kết nối DB)
////    @Bean
////    public DriverManagerDataSource getDataSource() {
////        DriverManagerDataSource datasource = new DriverManagerDataSource();
////        datasource.setDriverClassName("com.mysql.jdbc.Driver");
////        datasource.setUrl("jdbc:mysql://localhost:3306/orm2?useSSL=false&useUnicode=true&characterEncoding=utf8");
////        datasource.setUsername("root");
////        datasource.setPassword("12345678");
////        return datasource;
////    }
////
////    // Hibernate config
////    private final Properties hibernateProperties() {
////        Properties hibernateProperties = new Properties();
////        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update"); //create
////        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
////        return hibernateProperties;
////    }
////
////    // Step 2: config entityManagerFactory
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
////        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean ();
////        entityManagerFactory.setDataSource(getDataSource());
////        entityManagerFactory.setPackagesToScan(new String[]{"codegym.model"});
////
////        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
////        entityManagerFactory.setJpaProperties(hibernateProperties());
////        return entityManagerFactory;
////    }
////
////    // Step 3: Config entity manager
////    @Bean
////    @Qualifier(value = "entityManager")
////    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
////        return entityManagerFactory.createEntityManager();
////    }
////
////    // Step 4: Transaction support
////    @Bean
////    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
////        JpaTransactionManager transactionManager = new JpaTransactionManager();
////        transactionManager.setEntityManagerFactory(entityManagerFactory);
////        return transactionManager;
////    }
//
//
//import codegym.repository.CustomerRepository;
//import codegym.repository.CustomerRepositoryImpl;
//import codegym.service.CustomerService;
//import codegym.service.CustomerServiceImpl;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableWebMvc
//@EnableTransactionManagement
//@ComponentScan("codegym")
//public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public CustomerRepository customerRepository(){
//        return new CustomerRepositoryImpl();
//    }
//
//    @Bean
//    public CustomerService customerService(){
//        return new CustomerServiceImpl();
//    }
//
//
//    //Thymeleaf Configuration
//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/views/thymeleaf");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        return templateResolver;
//    }
//
//    @Bean
//    public TemplateEngine templateEngine(){
//        TemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver viewResolver(){
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        return viewResolver;
//    }
//
//    //JPA configuration
//    @Bean
//    @Qualifier(value = "entityManager")
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[]{"codegym.model"});
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//        return em;
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/cms");
//        dataSource.setUsername( "root" );
//        dataSource.setPassword( "12345678" );
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        return properties;
//    }
//}

package codegym.config;

import codegym.repository.CustomerRepository;
import codegym.repository.CustomerRepositoryImpl;
import codegym.service.CustomerService;
import codegym.service.CustomerServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("codegym")
public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }


    //Thymeleaf Configuration
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/views/thymeleaf");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3360/customer");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        return dataSource;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }


    //JPA configuration


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"codegym.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}

