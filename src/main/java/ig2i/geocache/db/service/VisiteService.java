package ig2i.geocache.db.service;

import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.User;
import ig2i.geocache.entity.Visite;

import java.util.List;

public interface VisiteService {

    Visite findVisiteById(String id);

    List<Visite> findAll();

    void deleteAll();

    void delete(String id);

    Visite save(Visite u);

    Visite saveWithCacheAndUser(Visite visite, Cache c, User u);
}
