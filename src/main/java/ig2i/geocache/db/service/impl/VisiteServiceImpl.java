package ig2i.geocache.db.service.impl;

import ig2i.geocache.db.repository.VisiteRepository;
import ig2i.geocache.db.service.VisiteService;
import ig2i.geocache.entity.Visite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisiteServiceImpl implements VisiteService {

    private final VisiteRepository userRepository;

    public VisiteServiceImpl(VisiteRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Visite findVisiteById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<Visite> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Visite save(Visite u) {
        userRepository.save(u);
        return u;
    }
}
