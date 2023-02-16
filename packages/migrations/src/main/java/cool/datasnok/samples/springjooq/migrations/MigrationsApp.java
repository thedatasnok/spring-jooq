package cool.datasnok.samples.springjooq.migrations;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MigrationsApp {
  private final DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(MigrationsApp.class, args);
  }

  @Bean
  boolean schemaCreation() {
    new JdbcTemplate(this.dataSource).execute("CREATE SCHEMA IF NOT EXISTS library");
    return true; // assuming the above call will throw and cause an error before returning if it fails
  }

  @Bean
  @DependsOn("schemaCreation")
  SpringLiquibase liquibase() {
    var liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
    liquibase.setDataSource(this.dataSource);
    return liquibase;
  }

}
