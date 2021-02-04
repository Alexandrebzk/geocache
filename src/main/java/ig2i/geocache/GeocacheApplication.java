package ig2i.geocache;

import ig2i.geocache.entities.User;
import ig2i.geocache.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeocacheApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(GeocacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // fetch all customers
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (User customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // save a couple of customers
        repository.save(new User("Alice", "photo1","ceci est une description"));

        // fetch an individual customer
        System.out.println("User found with findByPseudo('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByPseudo("Alice"));

        System.out.println("Users found with findAll():");
        System.out.println("--------------------------------");
        for (User customer : repository.findAll()) {
            System.out.println(customer);
        }

    }
}
