package ig2i.geocache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "ig2i.geocache.db.repository.mariadb")
@EnableMongoRepositories(basePackages = "ig2i.geocache.db.repository.mongo")
@SpringBootApplication
public class GeocacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeocacheApplication.class, args);
    }
}
