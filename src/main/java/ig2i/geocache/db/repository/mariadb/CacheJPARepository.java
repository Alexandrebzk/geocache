package ig2i.geocache.db.repository.mariadb;

import ig2i.geocache.entity.Cache;
import ig2i.geocache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CacheJPARepository extends JpaRepository<Cache, String> {
}
