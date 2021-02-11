package ig2i.geocache.db.repository.mongo.impl;

import ig2i.geocache.db.repository.CacheRepository;
import ig2i.geocache.db.repository.mongo.CacheMongoRepository;
import ig2i.geocache.entity.Cache;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
public class CacheRepositoryImplMongo implements CacheRepository {


    private final CacheMongoRepository cacheMongoRepository;

    public CacheRepositoryImplMongo(CacheMongoRepository cacheMongoRepository) {
        this.cacheMongoRepository = cacheMongoRepository;
    }

    @Override
    public Cache findById(String id) {
        return cacheMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cache> findByUserId(String id) {
        return cacheMongoRepository.findCachesByProprietaireId(id).orElse(null);
    }

    @Override
    public List<Cache> findByLieuId(String id) {
        return cacheMongoRepository.findCachesByLieuId(id).orElse(null);
    }

    @Override
    public List<Cache> findByVisiteId(String id) {
        return cacheMongoRepository.findCachesByVisiteListContains(id).orElse(null);
    }

    @Override
    public Cache save(Cache c) {
        return cacheMongoRepository.save(c);
    }

    @Override
    public void saveAll(List<Cache> caches) {
        cacheMongoRepository.saveAll(caches);
    }

    @Override
    public void deleteAll() {
        cacheMongoRepository.deleteAll();
    }

    @Override
    public void delete(Cache c) {
        cacheMongoRepository.delete(c);
    }

    @Override
    public List<Cache> findAll() {
        return cacheMongoRepository.findAll();
    }
}
