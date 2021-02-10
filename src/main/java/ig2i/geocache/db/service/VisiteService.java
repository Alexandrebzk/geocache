package ig2i.geocache.db.service;

import ig2i.geocache.entity.Visite;

import java.util.List;

public interface VisiteService {

    Visite findVisiteById(String id);

    List<Visite> findAll();

    void deleteAll();

    Visite save(Visite u);

    Visite saveWithCacheAndUser(Visite visite,String cacheId, String userId);
}
