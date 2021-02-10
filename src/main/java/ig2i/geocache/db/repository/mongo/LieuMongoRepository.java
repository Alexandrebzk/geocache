package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Lieu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LieuMongoRepository extends MongoRepository<Lieu, String>  {

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Lieu'}")
    List<Lieu> findAll();

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Lieu'}")
    Optional<Lieu> findById(String s);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Lieu'}")
    void delete(Lieu lieu);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Lieu'}")
    void deleteAll();

}
