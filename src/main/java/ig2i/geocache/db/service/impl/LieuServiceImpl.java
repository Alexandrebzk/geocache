package ig2i.geocache.db.service.impl;

import ig2i.geocache.db.repository.LieuRepository;
import ig2i.geocache.db.service.LieuService;
import ig2i.geocache.entity.Lieu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LieuServiceImpl implements LieuService {

    private final LieuRepository lieuRepository;

    public LieuServiceImpl(LieuRepository lieuRepository) {
        this.lieuRepository = lieuRepository;
    }

    @Override
    public Lieu findLieuById(String id) {
        return lieuRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        lieuRepository.deleteAll();
    }

    @Override
    public List<Lieu> findAll() {
        return lieuRepository.findAll();
    }

    @Override
    public Lieu save(Lieu u) {
        lieuRepository.save(u);
        return u;
    }
}
