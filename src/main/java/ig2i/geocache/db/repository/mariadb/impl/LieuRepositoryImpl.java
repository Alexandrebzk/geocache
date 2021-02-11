package ig2i.geocache.db.repository.mariadb.impl;

import ig2i.geocache.db.repository.LieuRepository;
import ig2i.geocache.db.repository.mariadb.LieuJPARepository;
import ig2i.geocache.entity.Lieu;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mariadb")
@Repository
public class LieuRepositoryImpl implements LieuRepository {

    private final LieuJPARepository lieuJPARepository;

    public LieuRepositoryImpl(LieuJPARepository lieuJPARepository) {
        this.lieuJPARepository = lieuJPARepository;
    }

    @Override
    public Lieu findById(String id) {
        return lieuJPARepository.findById(id).orElse(null);
    }

    @Override
    public void save(Lieu u) {
        lieuJPARepository.save(u);
    }

    @Override
    public void delete(Lieu l) {
        lieuJPARepository.delete(l);
    }

    @Override
    public void saveAll(List<Lieu> users) {
        lieuJPARepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        lieuJPARepository.deleteAll();
    }

    @Override
    public List<Lieu> findAll() {
        return lieuJPARepository.findAll();
    }
}
