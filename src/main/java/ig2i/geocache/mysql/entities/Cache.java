package ig2i.geocache.mysql.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Document
public class Cache {
    @Id
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
}
