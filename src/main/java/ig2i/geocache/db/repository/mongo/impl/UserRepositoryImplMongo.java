package ig2i.geocache.db.mongo.repository;

import ig2i.geocache.db.UserRepository;
import ig2i.geocache.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
public class UserRepositoryImplMongo implements UserRepository {


    private final UserMongoRepository userMongoRepository;

    public UserRepositoryImplMongo(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User findById(String id) {
        return userMongoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User u) {
        userMongoRepository.save(u);
    }

    @Override
    public void saveAll(List<User> users) {
        userMongoRepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        userMongoRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        return userMongoRepository.findAll();
    }
}
