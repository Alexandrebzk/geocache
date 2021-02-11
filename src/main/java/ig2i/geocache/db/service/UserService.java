package ig2i.geocache.db.service;

import ig2i.geocache.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(String id);

    List<User> findAll();

    void deleteAll();

    User save(User u);

    void delete(String userId);
}
