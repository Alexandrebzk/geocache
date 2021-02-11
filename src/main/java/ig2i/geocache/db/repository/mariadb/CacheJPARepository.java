package ig2i.geocache.db.repository.mariadb;

import ig2i.geocache.entity.Cache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CacheJPARepository extends JpaRepository<Cache, String> {

    Optional<List<Cache>> findCacheByProprietaireId(String id);

    Optional<List<Cache>> findCachesByLieuId(String id);

    Optional<List<Cache>> findCachesByVisiteListContains(String id);
}
