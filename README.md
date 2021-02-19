# GeoCache

Belcour Hadrien - Barczyk Alexandre

## Installation

#### Maven

````bash
mvn clean install
````

#### Maven dans InteliJ

![config_maven](/Users/alex/Desktop/config_maven.png)



## Configuration - À modifier pour votre système



src/main/resources/application.properties

```properties
#Profil = mongodb OU mariadb
spring.profiles.active=mariadb
# MySQL (de base)
spring.datasource.url=jdbc:mysql://192.168.64.2:3306/geocache
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=none
```

src/main/resources/application-mongodb.properties

`````properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=poo
`````

src/main/resources/application-mariadb.properties

````properties
spring.datasource.url=jdbc:mysql://192.168.64.2:3306/geocache
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=none
````



## Lancement MongoDB

```bash
java -jar -Dspring.profiles.active=mongodb target/geocache-1.0.jar 
```



## Lancement MariaDB

```bash
java -jar -Dspring.profiles.active=mariadb target/geocache-1.0.jar 
```



## Lancement InteliJ

![config_spring](/Users/alex/Desktop/config_spring.png)



## Pourquoi SpringBoot



### Qu'est ce que SpringBoot

Spring Boot est un Framework de Spring. Il permet notamment d'utiliser des directives (@<NomDirective>)  pour faciliter l'utilisation / la configuration de notre application. Ces directives permettent de paramétrer de l'injection de dépendance(s). 





### Avantages



#### Injection de dépendances

Comme dit plus haut, Spring Boot permet l'injection de dépendance, voila comment nous nous en servons dans notre projet :

````java
public class GeocacheConsole implements CommandLineRunner {

    private final UserService userService;
    private final LieuService lieuService;
    private final CacheService cacheService;
    private final VisiteService visiteService;
  
    public GeocacheConsole(UserService userService, LieuService lieuService, CacheService cacheService, 		 VisiteService visiteService) {
        this.userService = userService;
        this.lieuService = lieuService;
        this.cacheService = cacheService;
        this.visiteService = visiteService;
    }
  // ...
}
````

Lorsqu'un service <Entity>Service va être passé en paramètre du constructeur de GeocacheConsole, Spring Boot va aller scanner les "Beans" disponibles, s'il en trouve une qui correspond à ce qu'on lui demande, il l'instancie et nous la fournie. Mais c'est quoi une Bean ?

````java
@Service
public class UserServiceImpl implements UserService {
//..
}
````

Sans surprise, une Bean est une Graine :smile:

Notre directive @Service (au même titre que les directives @Repository que vous retrouverez dans le code) spécifie à Spring Boot que nous lui laissons l'instancier pour nous. Derrière celle-ci se cache ce que l'on appelle un [conteneur Spring IoC](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-introduction)  qui va stocker cette bean et qui la construira à la demande.





#### @Profile()

##### Définition

La raison principale de notre choix, la directive @Profile. Nous ne l'avons pas dit avant mais Spring Boot utilise un système de fichier de configuration permettant d'initialiser l'application dans un certain contexte. On peut par exemple lui spécifier les différents paramètres de connexion à notre BDD (MariaDB ou MongoDB): 

````properties
# MySQL
spring.datasource.url=jdbc:mysql://192.168.64.2:3306/geocache
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=none
# MongoDB
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=poo
````

Les champs sont explicites et vraiment pas différent d'une configuration JPA standard, on y précise les mêmes choses pour initialiser la connexion à la BDD.

Cette fameuse directive **@Profile** nous permet de modifier le comportement de notre application suivant une certaine variable dans la configuration:

````properties
spring.profiles.active=mariadb
````

On peut donc créer autant de profils que de configurations différentes que l'on veut mettre en place !

La valeur de cette variable va permettre d'utiliser le fichier **application-mariadb.properties** dans ce cas d'exemple.

##### Utilisation dans l'application

````java
public interface UserRepository {
  // ...
}
````

Voici ce que l'on utilise pour manipuler des données. Avant de passer aux explications et pour ne pas trop perdre le fil. On va d'abord préciser comment cette interface est implémentée suivant les profiles, voila le processus: 

````java
@Profile("mariadb")
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository userJPARepository;
  
  //...
}
````

`````java
@Repository
@Profile("mongodb")
public class UserRepositoryImplMongo implements UserRepository {
    
    private final UserMongoRepository userMongoRepository;
    /...
}
`````

La directive **@Repository** va permettre son injection (voir plus haut) mais on précise également dans quel contexte implémenter celui-ci avec **@Profile("NOM_PROFIL")**.





#### Repository



Nous sommes désormais capable d'avoir une Interface qui sera implémentée par Spring Boot selon nos besoins (MariaDB ou MongoDB). Ici, pas d'entity manager, enfin presque... En fait, il est bien caché dans les différentes implémentations, comme on laisse Spring Boot s'occuper de tout, on a l'impression de ne pas en manipuler. Nous allons développer autour de JPA mais c'est le même comportement du côté de Mongo:



Cette classe est la nôtre, c'est celle qui va hériter de toutes les propriétés / fonctionnalités disponible du JpaRepository.

```java
public interface UserJPARepository extends JpaRepository<User, String> {
  
}
```

Ici on commence à rentrer dans les détails, on découvre les fonctions que l'on peut manipuler nativement (pour une Entité donnée) mais toujours aucune trace d'entity manager...

````java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAllById(Iterable<ID> var1);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);
}
````

Après quelques recherches pour comprendre comment tout cela fonctionne, on trouve enfin notre bien aimé EntityManager dans l'interface [SimpleJpaRepository](https://github.com/spring-projects/spring-data-jpa/blob/master/src/main/java/org/springframework/data/jpa/repository/support/SimpleJpaRepository.java).

````java
public class SimpleJpaRepository<T, ID> implements JpaRepositoryImplementation<T, ID> {
    private static final String ID_MUST_NOT_BE_NULL = "The given id must not be null!";
    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private final PersistenceProvider provider;
    // ...
}
````

Toutes ces cabrioles dans la documentation Spring nous ont permis de comprendre ce qu'on manipulait. À partir de maintenant, on sait que tout cela n'est pas magique, qu'on manipule bien les mêmes choses qu'en cours.



## Architecture

````bash
├── db
├── src
│   ├── main
│       ├── java
│       │   └── ig2i
│       │       └── geocache
│       │           ├── application
│       │           ├── db
│       │           │   ├── repository
│       │           │   │   ├── mariadb
│       │           │   │   │   └── impl
│       │           │   │   └── mongo
│       │           │   │       └── impl
│       │           │   └── service
│       │           │       └── impl
│       │           └── entity
│       └── resources
└── target
````

### Package entity

````bash
├── Cache.java
├── Lieu.java
├── User.java
└── Visite.java
````

Ce package recense les entités qui seront manipulées par le JAVA. À savoir que ces entités sont génériques (elles fonctionnent aussi bien pour MariaDB et MongoDB)

### Package Service

```bash
├── CacheService.java
├── LieuService.java
├── UserService.java
├── VisiteService.java
└── impl
    ├── CacheServiceImpl.java
    ├── LieuServiceImpl.java
    ├── UserServiceImpl.java
    └── VisiteServiceImpl.java
```

Ce package contient les services permettant d'appeler les différentes méthodes de gestion des entités (CRUD) ainsi que les fonctionnalités recherche avancées (trouver une cache en fonction de son utilisateur etc ...)

### Package Repository

````bash
├── CacheRepository.java
├── LieuRepository.java
├── UserRepository.java
├── VisiteRepository.java
├── mariadb
│   ├── CacheJPARepository.java
│   ├── LieuJPARepository.java
│   ├── UserJPARepository.java
│   ├── VisiteJPARepository.java
│   └── impl
│       ├── CacheRepositoryImpl.java
│       ├── LieuRepositoryImpl.java
│       ├── UserRepositoryImpl.java
│       └── VisiteRepositoryImpl.java
└── mongo
    ├── CacheMongoRepository.java
    ├── LieuMongoRepository.java
    ├── UserMongoRepository.java
    ├── VisiteMongoRepository.java
    └── impl
        ├── CacheRepositoryImplMongo.java
        ├── LieuRepositoryImplMongo.java
        ├── UserRepositoryImplMongo.java
        └── VisiteRepositoryImplMongo.java
````

C'est ici que la bascule entre MariaDB et MongoDB va être mise en place. Suivant le Profile choisit (mariadb ou mongodb) les interfaces  <Entity>Repository.java vont être instanciées sous la forme de <Entity>JPARepository.java ou <Entity>MongoRepository.java. 



