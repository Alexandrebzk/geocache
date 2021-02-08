package ig2i.geocache.db.mongo.repository;

import ig2i.geocache.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserMongoRepository extends MongoRepository<User, String>  {
}
