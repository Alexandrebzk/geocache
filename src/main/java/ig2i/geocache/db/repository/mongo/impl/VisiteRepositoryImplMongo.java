package ig2i.geocache.db.repository.mongo.impl;

import ig2i.geocache.db.repository.VisiteRepository;
import ig2i.geocache.db.repository.mongo.VisiteMongoRepository;
import ig2i.geocache.entity.Visite;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
public class VisiteRepositoryImplMongo implements VisiteRepository {


    private final VisiteMongoRepository visiteMongoRepository;

    public VisiteRepositoryImplMongo(VisiteMongoRepository visiteMongoRepository) {
        this.visiteMongoRepository = visiteMongoRepository;
    }

    @Override
    public Visite findById(String id) {
        return visiteMongoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Visite u) {
        visiteMongoRepository.save(u);
    }

    @Override
    public void saveAll(List<Visite> caches) {
        visiteMongoRepository.saveAll(caches);
    }

    @Override
    public void deleteAll() {
        visiteMongoRepository.deleteAll();
    }

    @Override
    public List<Visite> findAll() {
        return visiteMongoRepository.findAll();
    }
}
