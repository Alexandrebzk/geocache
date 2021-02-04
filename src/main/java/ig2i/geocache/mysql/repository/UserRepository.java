package ig2i.geocache.mysql.repository;

import ig2i.geocache.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByPseudo(String pseudo);
}
