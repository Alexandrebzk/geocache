package ig2i.geocache.db.repository.mariadb;

import ig2i.geocache.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteJPARepository extends JpaRepository<Visite, String> {
}
