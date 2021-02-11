package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Visite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisiteMongoRepository extends MongoRepository<Visite, String> {
}
