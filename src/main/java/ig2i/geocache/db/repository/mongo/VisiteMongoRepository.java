package ig2i.geocache.db.repository.mongo;

import ig2i.geocache.entity.Visite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VisiteMongoRepository extends MongoRepository<Visite, String>  {


    @Override
    @Query("{'_class':'ig2i.geocache.entity.Visite'}")
    List<Visite> findAll();

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Visite'}")
    Optional<Visite> findById(String s);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Visite'}")
    void delete(Visite visite);

    @Override
    @Query("{'_class':'ig2i.geocache.entity.Visite'}")
    void deleteAll();
}
