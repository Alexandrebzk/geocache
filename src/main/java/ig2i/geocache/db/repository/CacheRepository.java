package ig2i.geocache.db.repository;

import ig2i.geocache.entity.Cache;

import java.util.List;

public interface CacheRepository {

    Cache findById(String id);

    void saveAll(List<Cache> users);

    void deleteAll();

    List<Cache> findAll();

    Cache save(Cache u);
}
