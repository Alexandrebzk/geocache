package ig2i.geocache.db.mariadb.repository;

import ig2i.geocache.db.UserRepository;
import ig2i.geocache.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mariadb")
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository userJPARepository;

    public UserRepositoryImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public User findById(String id) {
        return userJPARepository.findById(id).orElse(null);
    }

    @Override
    public void save(User u) {
        userJPARepository.save(u);
    }

    @Override
    public void saveAll(List<User> users) {
        userJPARepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        userJPARepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        return userJPARepository.findAll();
    }
}
