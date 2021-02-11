package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Lieu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LieuMongoRepository extends MongoRepository<Lieu, String> {

}
