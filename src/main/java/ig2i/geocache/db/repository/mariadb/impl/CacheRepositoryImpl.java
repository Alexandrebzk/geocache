package ig2i.geocache.db.repository.mariadb.impl;

import ig2i.geocache.db.repository.CacheRepository;
import ig2i.geocache.db.repository.mariadb.CacheJPARepository;
import ig2i.geocache.entity.Cache;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mariadb")
@Repository
public class CacheRepositoryImpl implements CacheRepository {

    private final CacheJPARepository cacheJPARepository;

    public CacheRepositoryImpl(CacheJPARepository cacheJPARepository) {
        this.cacheJPARepository = cacheJPARepository;
    }

    @Override
    public Cache findById(String id) {
        return cacheJPARepository.findById(id).orElse(null);
    }

    @Override
    public Cache save(Cache u) {
        return cacheJPARepository.save(u);
    }

    @Override
    public void saveAll(List<Cache> users) {
        cacheJPARepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        cacheJPARepository.deleteAll();
    }

    @Override
    public List<Cache> findAll() {
        return cacheJPARepository.findAll();
    }
}
