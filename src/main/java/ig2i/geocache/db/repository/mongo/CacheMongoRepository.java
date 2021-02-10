package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Cache;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CacheMongoRepository extends MongoRepository<Cache, String>  {

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Cache'}")
    List<Cache> findAll();

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Cache'}")
    Optional<Cache> findById(String s);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Cache'}")
    void delete(Cache cache);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Cache'}")
    void deleteAll();
}
