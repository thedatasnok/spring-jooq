package cool.datasnok.samples.springjooq.jooq;

import javax.sql.DataSource;

import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JooqConfig {
  private final DataSource dataSource;

  @Bean
  DataSourceConnectionProvider connectionProvider() {
    return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(this.dataSource));
  }

  @Bean
  DefaultConfiguration configuration() {
    var configuration = new DefaultConfiguration();
    configuration.set(connectionProvider());
    return configuration;
  }

  @Bean
  DefaultDSLContext dslContext() {
    return new DefaultDSLContext(this.configuration());
  }

}
