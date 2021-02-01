package ig2i.geocache.repository;
import java.util.List;

import ig2i.geocache.mysql.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public User findByPseudo(String firstName);

    public List<User> findAll();

}