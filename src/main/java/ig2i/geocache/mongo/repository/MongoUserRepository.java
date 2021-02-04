package ig2i.geocache.mongo.repository;
import java.util.List;

import ig2i.geocache.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String> {

    public User findByPseudo(String firstName);

    public List<User> findAll();

}
