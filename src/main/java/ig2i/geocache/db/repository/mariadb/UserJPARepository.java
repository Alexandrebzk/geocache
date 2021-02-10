package ig2i.geocache.db.repository.mariadb;

import ig2i.geocache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, String> {
}
