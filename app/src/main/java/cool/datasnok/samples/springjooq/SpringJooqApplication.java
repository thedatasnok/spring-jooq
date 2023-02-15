package cool.datasnok.samples.springjooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringJooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJooqApplication.class, args);
	}

}
