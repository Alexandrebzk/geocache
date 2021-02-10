package ig2i.geocache.db.service.impl;

import ig2i.geocache.db.repository.CacheRepository;
import ig2i.geocache.db.service.CacheService;
import ig2i.geocache.db.service.UserService;
import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;
    private final UserService userService;

    public CacheServiceImpl(CacheRepository cacheRepository, UserService userService) {
        this.cacheRepository = cacheRepository;
        this.userService = userService;
    }

    @Override
    public Cache findCacheById(String id) {
        return cacheRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        cacheRepository.deleteAll();
    }
    @Override
    public void delete(String id) {

        cacheRepository.delete(cacheRepository.findById(id));
    }

    @Override
    public List<Cache> findAll() {
        return cacheRepository.findAll();
    }

    @Override
    public Cache save(Cache u) {
        cacheRepository.save(u);
        return u;
    }

    @Override
    public Cache saveWithUser(Cache cache, String userId) {
        User u = userService.findUserById(userId);
        cacheRepository.save(cache);
        if (u != null) {
            u.addCache(cache);
            userService.save(u);
            cache.setProprietaire(u);
        }

        return cacheRepository.save(cache);
    }
}
