package com.sm.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.sm.repository")
@EntityScan("com.sm.repository")
@EnableTransactionManagement
public class DatabaseConfig {

	
  /*private static final String HIBERNATE_FORMAT_SQL = "spring.jpa.format_sql";

  @Autowired private Environment env;


  @Primary
  @Bean
 public DataSource batchDataSource(
		 @Qualifier("databaseCredential") Credential databaseCredential,
		@Value("${database.driver-class-name}") String driverClassName,
		@Value("${database.url}")  String url,
		@Value("${database.maxPoolSize}") int maxPoolSize,
		@Value("${database.minIdlePoolSize}") int minIdlePoolSize,
		@Value("${database.poolName}")  String poolName)
  {
		
final CredentialDataSource credentialDataSource=
createCredentialDataSource(databaseCredential, driverClassName, url);
			
fianl HikariConfig config = 
createHikariConfig(driverClassName,credentialDataSource,maxPoolSize,minIdlePoolSize,poolName );		
			
final DataSource hikariDataSource = new HikariDataSource(config);
return hikariDataSource;
		}
 
  @Bean
  public EntityManagerFactory entityManagerFactory() {
    final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabasePlatform(this.env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
    jpaVendorAdapter.setShowSql(
        Boolean.valueOf(this.env.getRequiredProperty("spring.jpa.show-sql")));
    jpaVendorAdapter.setGenerateDdl(
        Boolean.valueOf(this.env.getRequiredProperty("spring.jpa.hibernate.ddl-auto")));

    final LocalContainerEntityManagerFactoryBean entityManagerFactory =
        new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(this.dataSource());
    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
    entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
    entityManagerFactory.setPackagesToScan(
        "com.person.entity");

    final Properties jpaProperties = new Properties();
    jpaProperties.put(HIBERNATE_FORMAT_SQL, this.env.getRequiredProperty(HIBERNATE_FORMAT_SQL));

    entityManagerFactory.setJpaProperties(jpaProperties);
    entityManagerFactory.afterPropertiesSet();

    return entityManagerFactory.getObject();
  }

  
  @Bean
  public PlatformTransactionManager transactionManager() {
    final JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(this.entityManagerFactory());

    return txManager;
  }*/
}
