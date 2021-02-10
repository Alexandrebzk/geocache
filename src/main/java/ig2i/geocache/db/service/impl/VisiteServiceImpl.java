package ig2i.geocache.db.service.impl;

import ig2i.geocache.db.repository.VisiteRepository;
import ig2i.geocache.db.service.CacheService;
import ig2i.geocache.db.service.UserService;
import ig2i.geocache.db.service.VisiteService;
import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.User;
import ig2i.geocache.entity.Visite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisiteServiceImpl implements VisiteService {

    private final VisiteRepository visiteRepository;
    private final CacheService cacheService;
    private final UserService userService;

    public VisiteServiceImpl(VisiteRepository visiteRepository, CacheService cacheService, UserService userService) {
        this.visiteRepository = visiteRepository;
        this.cacheService = cacheService;
        this.userService = userService;
    }

    @Override
    public Visite findVisiteById(String id) {
        return visiteRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        visiteRepository.deleteAll();
    }

    @Override
    public List<Visite> findAll() {
        return visiteRepository.findAll();
    }

    @Override
    public Visite save(Visite u) {
        visiteRepository.save(u);
        return u;
    }

    @Override
    public Visite saveWithCacheAndUser(Visite visite, String cacheId, String userId) {
        visiteRepository.save(visite);
        Cache c = cacheService.findCacheById(cacheId);
        User u = userService.findUserById(userId);
        if (c != null && u != null) {
            if (!u.hasVisite(visite)) {
                u.addVisite(visite);
                userService.save(u);
            }
            if (!c.hasVisite(visite)) {
                c.addVisite(visite);
                cacheService.save(c);
            }
            if (!u.hasCache(c)) {
                cacheService.saveWithUser(c, u.getId());
            }
            visite.setCache(c);
            visite.setUser(u);
            visiteRepository.save(visite);
        }
        return visite;
    }
}
