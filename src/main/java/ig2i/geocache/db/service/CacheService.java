package ig2i.geocache.db.service;

import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.User;

import java.util.List;

public interface CacheService {

    Cache findCacheById(String id);

    List<Cache> findAll();

    void deleteAll();

    void delete(String visiteId);

    Cache save(Cache u);

    Cache saveWithUser(Cache cache, String userId);
}
