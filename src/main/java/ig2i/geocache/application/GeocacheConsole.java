package ig2i.geocache.application;

import com.github.javafaker.Faker;
import ig2i.geocache.db.service.CacheService;
import ig2i.geocache.db.service.LieuService;
import ig2i.geocache.db.service.UserService;
import ig2i.geocache.db.service.VisiteService;
import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.Lieu;
import ig2i.geocache.entity.User;
import ig2i.geocache.entity.Visite;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

@Component
public class GeocacheConsole implements CommandLineRunner {

    private final UserService userService;
    private final LieuService lieuService;
    private final CacheService cacheService;
    private final VisiteService visiteService;


    public GeocacheConsole(UserService userService, LieuService lieuService, CacheService cacheService, VisiteService visiteService) {
        this.userService = userService;
        this.lieuService = lieuService;
        this.cacheService = cacheService;
        this.visiteService = visiteService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Liste des commandes :");
            System.out.println("\t- get user|cache|lieu|visite [id]|all");
            System.out.println("\t- add user|cache|lieu|visite field1:field2:field3:...");
            System.out.println("\t\t - For USER : ");
            System.out.println("\t\t\t - add user pseudo:photo:description");
            System.out.println("\t\t - For CACHE : ");
            System.out.println("\t\t\t - add cache description:type:nature:etat:geolocalisation:userId (userId = Optionnel)");
            System.out.println("\t\t - For LIEU : ");
            System.out.println("\t\t\t - add lieu nom ");
            System.out.println("\t\t - For VISITE : ");
            System.out.println("\t\t\t - add visite commentaire:photo:cacheId:userId (cacheId & userId = optionnels MAIS si un spécifié autre obligatoire) ");
            System.out.println("Saisissez votre commande :");
            String command = scanner.nextLine();

            String[] commandSplit = command.split(" ");
            switch (commandSplit[0]) {
                case "get":
                    if (commandSplit[1] != null)
                        switch (commandSplit[1]) {
                            case "cache":
                                if (commandSplit[2].equalsIgnoreCase("all"))
                                    System.out.println(cacheService.findAll());
                                else System.out.println(cacheService.findCacheById(commandSplit[2]));
                                break;
                            case "visite":
                                if (commandSplit[2].equalsIgnoreCase("all"))
                                    System.out.println(visiteService.findAll());
                                else System.out.println(visiteService.findVisiteById(commandSplit[2]));
                                break;
                            case "user":
                                if (commandSplit[2].equalsIgnoreCase("all"))
                                    System.out.println(userService.findAll());
                                else System.out.println(userService.findUserById(commandSplit[2]));
                                break;
                            case "lieu":
                                if (commandSplit[2].equalsIgnoreCase("all"))
                                    System.out.println(lieuService.findAll());
                                else System.out.println(lieuService.findLieuById(commandSplit[2]));
                                break;
                            default:
                                System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                        }
                    break;
                case "add":
                    if (commandSplit[1] != null)
                        switch (commandSplit[1]) {
                            case "cache":
                                String[] fields = commandSplit[2].split(":");
                                if (fields.length == 5)
                                    System.out.println(cacheService.save(new Cache(fields[0], fields[1], fields[2], fields[3], fields[4])));
                                else if (fields.length == 6) {
                                    System.out.println(cacheService.saveWithUser(new Cache(fields[0], fields[1], fields[2], fields[3], fields[4]), fields[5]));
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            case "visite":
                                fields = commandSplit[2].split(":");
                                if (fields.length == 2) {
                                    System.out.println(visiteService.save(new Visite(fields[0], fields[1])));
                                } else if (fields.length == 4) {
                                    System.out.println(visiteService.saveWithCacheAndUser(new Visite(fields[0], fields[1]), fields[2], fields[3]));
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            case "user":
                                fields = commandSplit[2].split(":");
                                if (fields.length != 3) {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                System.out.println(userService.save(new User(fields[0], fields[1], fields[2])));
                                break;
                            case "lieu":
                                fields = commandSplit[2].split(":");
                                if (fields.length != 1) {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                System.out.println(lieuService.save(new Lieu(fields[0])));
                                break;
                            default:
                                System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                    break;
                case "delete":
                    if (commandSplit[1] != null)
                        switch (commandSplit[1]) {
                            case "cache":
                                if (commandSplit[2].equalsIgnoreCase("all")) {
                                    cacheService.deleteAll();
                                    System.out.println(cacheService.findAll());
                                } else {
                                    cacheService.delete(commandSplit[2]);
                                    System.out.println(cacheService.findCacheById(commandSplit[2]));
                                }
                                break;
                            default:
                                System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                        }
                    break;
                case "update":
                    break;
                case "populate":
                    Faker faker = new Faker(new Locale("fr"));
                    for (int i = 0; i < 3; i++) {
                        User user = new User(faker.name().firstName(), faker.pokemon().name(), faker.lorem().fixedString(30));
                        userService.save(user);
                        for (int j = 0; j < 2; j++) {
                            Cache cache = new Cache(faker.lorem().fixedString(30), "TYPE " + j, "NATURE " + j, "ETAT " + j, faker.address().latitude() + " : " + faker.address().longitude());
                            cacheService.saveWithUser(cache, user.getId());
                            Visite visite = new Visite("DESCRIPTION " + j, "VISITE " + j);
                            visiteService.saveWithCacheAndUser(visite, cache.getId(), user.getId());
                        }
                    }
                    break;
                case "exit":
                    System.out.printf("Merci d'avoir choisi GéoCache !");
                    System.exit(0);
                    break;
                default:
                    System.out.printf("L'action '%s' n'est pas reconnue %n", commandSplit[0]);
            }
        }

    }
}
