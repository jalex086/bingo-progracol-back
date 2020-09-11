package com.progracol.backend.apirest.conf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Clase que define el datasource encargado de manejar la conexion con la bd de juego <br>
 * 
 * @author Jonathan Mosquera.</a></br>
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.progracol.backend.apirest.models.juego.entity")
@EnableJpaRepositories(entityManagerFactoryRef = "juegoEntityManagerFactory", transactionManagerRef = "juegoTransactionManager", basePackages = {
		"com.progracol.backend.apirest.models.juego.dao" })
public class JuegoDbConfig {

	@Bean(name = "juegoDataSourceProperties")
	@Primary
	@ConfigurationProperties("juegobd.spring.datasource")
	public DataSourceProperties juegoDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "juegoDataSource")
	@Primary
	@ConfigurationProperties("juegobd.spring.datasource")
	public HikariDataSource juegoDataSource(@Qualifier("juegoDataSourceProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "juegoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean juegoEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("juegoDataSource") DataSource dataSource) {

		Map<String, Object> properties = new HashMap<>();

		return builder.dataSource(dataSource).packages("com.progracol.backend.apirest.models.juego.entity").properties(properties).persistenceUnit("juegoPU")
				.build();
	}

	@Primary
	@Bean(name = "juegoTransactionManager")
	public PlatformTransactionManager juegoTransactionManager(@Qualifier("juegoEntityManagerFactory") EntityManagerFactory entityManagerFactory)
			throws IOException {
		Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
		JpaTransactionManager jpaT = new JpaTransactionManager(entityManagerFactory);
		jpaT.setJpaProperties(properties);
		return jpaT;
	}

}