package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {


    @Override
    @Query("{'_class':'ig2i.geocache.entity.User'}")
    List<User> findAll();

    @Override
    @Query("{'_class':'ig2i.geocache.entity.User', '_id' : ?0}")
    Optional<User> findById(String s);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.User'}")
    void delete(User user);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.User'}")
    void deleteAll();
}
