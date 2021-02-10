package ig2i.geocache.db.service;

import ig2i.geocache.entity.Lieu;

import java.util.List;

public interface LieuService {

    Lieu findLieuById(String id);

    List<Lieu> findAll();

    void deleteAll();

    Lieu save(Lieu u);
}
