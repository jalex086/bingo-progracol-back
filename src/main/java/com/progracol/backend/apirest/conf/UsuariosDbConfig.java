package com.progracol.backend.apirest.conf;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Clase que define el datasource encargado de manejar la conexion con la bd de Usuarios <br>
 * 
 * @author Jonathan Mosquera.</a></br>
 */
@Configuration
@EntityScan("com.progracol.backend.apirest.models.usuarios.entity")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager", basePackages = {
		"com.progracol.backend.apirest.models.usuarios.dao" })
public class UsuariosDbConfig {

	@Bean(name = "dataSourceUserProperties")
	@ConfigurationProperties("userbd.spring.datasource")
	public DataSourceProperties dataSourceUserProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "userDateSource")
	@ConfigurationProperties("userbd.spring.datasource")
	public HikariDataSource userDateSource(@Qualifier("dataSourceUserProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "userEntityManagerFactory")
	public EntityManagerFactory userEntityManagerFactory(@Qualifier("userDateSource") DataSource dataSource) {
		Properties properties = new Properties();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.progracol.backend.apirest.models.usuarios.entity");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(properties);
		factoryBean.setPersistenceUnitName("userPU");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory)
			throws IOException {
		Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
		JpaTransactionManager jpaT = new JpaTransactionManager(entityManagerFactory);
		jpaT.setJpaProperties(properties);
		jpaT.setEntityManagerFactory(entityManagerFactory);
		return jpaT;
	}
}
