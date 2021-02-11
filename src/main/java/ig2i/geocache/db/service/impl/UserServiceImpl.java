package ig2i.geocache.db.service.impl;

import ig2i.geocache.db.repository.UserRepository;
import ig2i.geocache.db.service.UserService;
import ig2i.geocache.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User u) {
        userRepository.save(u);
        return u;
    }

    @Override
    public void delete(String userId) {
        User user = userRepository.findById(userId);
        if (user != null)
            userRepository.delete(user);
    }
}
