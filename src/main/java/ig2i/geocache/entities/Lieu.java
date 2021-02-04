package ig2i.geocache.mysql.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

@Entity
@Document
public class Lieu {
    @Id
    private String id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "lieu")
    private Set<Cache> caches;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
