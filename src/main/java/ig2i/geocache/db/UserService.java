package ig2i.geocache.db;

import ig2i.geocache.entity.User;

import java.util.List;

public interface UserService {

    User findCacheById(String id);

    List<User> findAll();

    void deleteAll();

    void save(User u);
}
