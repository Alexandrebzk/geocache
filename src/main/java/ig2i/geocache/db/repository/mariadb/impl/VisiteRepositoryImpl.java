package ig2i.geocache.db.repository.mariadb.impl;

import ig2i.geocache.db.repository.VisiteRepository;
import ig2i.geocache.db.repository.mariadb.VisiteJPARepository;
import ig2i.geocache.entity.Visite;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mariadb")
@Repository
public class VisiteRepositoryImpl implements VisiteRepository {

    private final VisiteJPARepository visiteJPARepository;

    public VisiteRepositoryImpl(VisiteJPARepository visiteJPARepository) {
        this.visiteJPARepository = visiteJPARepository;
    }

    @Override
    public Visite findById(String id) {
        return visiteJPARepository.findById(id).orElse(null);
    }

    @Override
    public void save(Visite u) {
        visiteJPARepository.save(u);
    }

    @Override
    public void saveAll(List<Visite> users) {
        visiteJPARepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        visiteJPARepository.deleteAll();
    }

    @Override
    public List<Visite> findAll() {
        return visiteJPARepository.findAll();
    }
}
