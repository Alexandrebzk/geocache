package ig2i.geocache.db.repository;

import ig2i.geocache.entity.Visite;

import java.util.List;

public interface VisiteRepository {

    Visite findById(String id);

    void saveAll(List<Visite> users);

    void deleteAll();

    void delete(Visite v);

    List<Visite> findAll();

    void save(Visite u);
}
