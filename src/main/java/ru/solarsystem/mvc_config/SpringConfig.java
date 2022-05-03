package ru.solarsystem.mvc_config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.solarsystem.model.MessageDto;
import ru.solarsystem.model.SmsDto;
import ru.solarsystem.model.СhannelDto;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@EnableJpaRepositories("ru.solarsystem.data")
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:/prop.properties")
@SpringBootApplication(scanBasePackages = "ru.solarsystem")
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringConfig.class, args);
/*
        HashMap<String, List<String>> jsonMap = new ObjectMapper().readValue(new FileInputStream("d:/sample.txt"), HashMap.class);

        for(Map.Entry<String, List<String>> map : jsonMap.entrySet()) {

            System.out.println(map.getKey());
            for(String x : map.getValue()) {
                System.out.println(x + " ");
            }
            System.out.println();
        }
*/

        HashMap<String, String> mapClean = new HashMap<>();
        mapClean.put("<%MessagName%>", "name");
        mapClean.put("<%MessagAge%>", "age");
        mapClean.put("<%СhannelName%>", "name");
        mapClean.put("<%СhannelSize%>", "size");
        mapClean.put("<%SmsName%>", "name");
        mapClean.put("<%Buf%>", "bufer");

        // впоследствии вынести ключ-значение в отдельный конфиг в виде JSON
        HashMap<String, String> mapKey = new HashMap<>();
        mapKey.put("<%СhannelName%>", "chen");
        mapKey.put("<%СhannelSize%>", "chen");
        mapKey.put("<%SmsName%>", "sms");
        mapKey.put("<%Buf%>", "sms");

        MessageDto mess = new MessageDto();
        СhannelDto chen = new СhannelDto();
        SmsDto sms = new SmsDto();

        sms.setBufer(100);
        sms.setName("smsname ghfh");

        chen.setName("name");
        chen.setSize(999);
        chen.setSms(sms);

        mess.setAge(123);
        mess.setName("messname");
        mess.setChen(chen);

        String messageToStringJson = new ObjectMapper().writeValueAsString(mess);

        System.out.println(messageToStringJson);

        List<String> listMessage = Arrays.asList(messageToStringJson.split("[\":},{]")).stream().filter(item -> !item.equals("")).collect(Collectors.toList());

        for (Map.Entry<String, String> mapKeyObj : mapKey.entrySet()) {
            for (Map.Entry<String, String> mapCleanMarker : mapClean.entrySet()) {

                if (mapKeyObj.getKey().equalsIgnoreCase(mapCleanMarker.getKey())) {

                    List<String> subListMessage = listMessage.subList(listMessage.indexOf(mapKeyObj.getValue()), listMessage.size());
                    int x = subListMessage.indexOf(mapCleanMarker.getValue()) + 1;

                    System.out.println(mapKeyObj.getKey() + " " + mapKeyObj.getValue());

                    mapClean.put(mapCleanMarker.getKey(), subListMessage.get(x));
                }
            }
        }

        for (Map.Entry<String, String> mapCleanMarker : mapClean.entrySet()) {

            if (listMessage.indexOf(mapCleanMarker.getValue()) != -1 && !mapKey.containsKey(mapCleanMarker.getKey())) {
                mapClean.put(mapCleanMarker.getKey(), listMessage.get(listMessage.indexOf(mapCleanMarker.getValue()) + 1));

            }
        }


        System.out.println("-------");
        for (Map.Entry<String, String> mapCleanMarker : mapClean.entrySet()) {
            System.out.println(mapCleanMarker.getKey() + " " + mapCleanMarker.getValue());
        }












        //


    }

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().username("postgres").password("admin").url("jdbc:postgresql://localhost:5432/MyDb").driverClassName("org.postgresql.Driver").build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }


    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }


    @Bean
    public EntityManagerFactory entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("ru.solarsystem");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }


    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setForceContentType(true);
        resolver.setContentType("text/html; charset=UTF-8");
        registry.viewResolver(resolver);
    }


}
