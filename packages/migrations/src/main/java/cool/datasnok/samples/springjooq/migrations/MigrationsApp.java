package cool.datasnok.samples.springjooq.migrations;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MigrationsApp {
  private final DataSource dataSource;

  public MigrationsApp(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public static void main(String[] args) {
    SpringApplication.run(MigrationsApp.class, args);
  }

  @PostConstruct
  void init() {
    new JdbcTemplate(this.dataSource).execute("CREATE SCHEMA IF NOT EXISTS library");
  }

}
