package ig2i.geocache.db.repository;

import ig2i.geocache.entity.Cache;

import java.util.List;

public interface CacheRepository {

    Cache findById(String id);

    void saveAll(List<Cache> users);

    void deleteAll();

    void delete(Cache c);

    List<Cache> findAll();

    List<Cache> findByUserId(String id);

    List<Cache> findByLieuId(String id);

    List<Cache> findByVisiteId(String id);

    Cache save(Cache u);
}
