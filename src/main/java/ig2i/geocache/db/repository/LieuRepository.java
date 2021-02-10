package ig2i.geocache.db.repository;

import ig2i.geocache.entity.Lieu;

import java.util.List;

public interface LieuRepository {

    Lieu findById(String id);

    void saveAll(List<Lieu> users);

    void deleteAll();

    List<Lieu> findAll();

    void save(Lieu u);
}
