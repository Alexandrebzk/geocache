package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Cache;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CacheMongoRepository extends MongoRepository<Cache, String> {

    Optional<List<Cache>> findCachesByProprietaireId(String id);

    Optional<List<Cache>> findCachesByLieuId(String id);

    Optional<List<Cache>> findCachesByVisiteListContains(String id);
}
