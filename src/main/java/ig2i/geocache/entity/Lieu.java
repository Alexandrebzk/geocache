package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Document("geocache")
public class Lieu {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "lieu", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Cache> caches;

    public Lieu() {
        this.caches = new ArrayList<>();
    }

    public Lieu(String nom) {
        this.nom = nom;
        this.caches = new ArrayList<>();
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
        if (this.caches != null)
            this.caches = new ArrayList<>();
        else
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
