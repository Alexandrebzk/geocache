package ig2i.geocache.db.repository;

import ig2i.geocache.entity.User;

import java.util.List;

public interface UserRepository {

    User findById(String id);

    void saveAll(List<User> users);

    void deleteAll();

    List<User> findAll();

    void save(User u);
}
