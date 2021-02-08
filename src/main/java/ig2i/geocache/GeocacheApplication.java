package ig2i.geocache;

import ig2i.geocache.db.UserService;
import ig2i.geocache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "ig2i.geocache.db.mariadb")
@EnableMongoRepositories(basePackages = "ig2i.geocache.db.mongo")
@SpringBootApplication
public class GeocacheApplication  {

    public static void main(String[] args) {
        SpringApplication.run(GeocacheApplication.class, args);
    }
}
