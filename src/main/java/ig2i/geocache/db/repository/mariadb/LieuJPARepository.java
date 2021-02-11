package ig2i.geocache.db.repository.mariadb;

import ig2i.geocache.entity.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuJPARepository extends JpaRepository<Lieu, String> {
}
