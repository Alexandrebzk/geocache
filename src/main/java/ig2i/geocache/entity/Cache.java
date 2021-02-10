package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Document("geocache")
public class Cache {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "nature")
    private String nature;
    @Column(name = "etat")
    private String etat;
    @Column(name = "geolocalisation")
    private String geolocalisation;
    @ManyToOne
    private Lieu lieu;
    @ManyToOne
    private User proprietaire;

    public Cache(){

    }

    public Cache(String description, String type, String nature, String etat, String geolocalisation) {
        this.description = description;
        this.type = type;
        this.nature = nature;
        this.etat = etat;
        this.geolocalisation = geolocalisation;
    }
    public Cache(String description, String type, String nature, String etat, String geolocalisation, User u) {
        this.description = description;
        this.type = type;
        this.nature = nature;
        this.etat = etat;
        this.geolocalisation = geolocalisation;
        this.proprietaire = u;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    @Override
    public String toString() {
        return "\nCache{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", nature='" + nature + '\'' +
                ", etat='" + etat + '\'' +
                ", geolocalisation='" + geolocalisation + '\'' +
                ", lieu=" + (lieu != null ? lieu.getNom() : "null") +
                ", proprietaire=" + (proprietaire != null ? proprietaire.getId() : "null") +
                '}';
    }
}
