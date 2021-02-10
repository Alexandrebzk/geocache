package ig2i.geocache.db.mariadb.repository;

import ig2i.geocache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserJPARepository extends JpaRepository<User, String> {
}
