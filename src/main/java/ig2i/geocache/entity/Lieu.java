package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Document
public class Lieu {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "lieu", cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @DBRef
    private List<Cache> caches = new ArrayList<>();

    public Lieu() {
    }

    public Lieu(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Cache> getCaches() {
        return caches;
    }

    public void setCaches(List<Cache> caches) {
        this.caches = caches;
    }

    public void addCache(Cache cache) {
        this.caches.add(cache);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "\nLieu{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", caches=" + caches +
                '}';
    }
}
