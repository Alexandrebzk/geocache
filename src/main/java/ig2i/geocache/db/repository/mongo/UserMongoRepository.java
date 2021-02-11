package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
}
