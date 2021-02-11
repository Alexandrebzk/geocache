package ig2i.geocache.db.repository.mongo.impl;

import ig2i.geocache.db.repository.LieuRepository;
import ig2i.geocache.db.repository.mongo.LieuMongoRepository;
import ig2i.geocache.entity.Lieu;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
public class LieuRepositoryImplMongo implements LieuRepository {


    private final LieuMongoRepository lieuMongoRepository;

    public LieuRepositoryImplMongo(LieuMongoRepository lieuMongoRepository) {
        this.lieuMongoRepository = lieuMongoRepository;
    }

    @Override
    public Lieu findById(String id) {
        return lieuMongoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Lieu u) {
        lieuMongoRepository.save(u);
    }

    @Override
    public void delete(Lieu l) {
        lieuMongoRepository.delete(l);
    }

    @Override
    public void saveAll(List<Lieu> users) {
        lieuMongoRepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        lieuMongoRepository.deleteAll();
    }

    @Override
    public List<Lieu> findAll() {
        return lieuMongoRepository.findAll();
    }
}
