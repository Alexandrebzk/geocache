package ig2i.geocache.application;

import ig2i.geocache.db.UserService;
import ig2i.geocache.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GeocacheConsole implements CommandLineRunner {

    private final UserService userService;

    public GeocacheConsole(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        userService.deleteAll();

        // save a couple of customers
        userService.save(new User("Alice", "photo1", "ceci est une description"));
        userService.save(new User("Albert", "photo2", "ceci est une description"));

        System.out.println("Users found with findAll():");
        System.out.println("--------------------------------");
        for (User customer : userService.findAll()) {
            System.out.println(customer);
        }

    }
}
