package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Document("geocache")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "photo")
    private String photo;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cache> caches = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visite> visiteList = new ArrayList<>();

    public User() {
    }

    public User(String pseudo, String photo, String description) {
        this.pseudo = pseudo;
        this.photo = photo;
        this.description = description;
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

    public boolean hasCache(Cache c) {
        for (Cache cache : this.caches)
            if (cache.getId().equals(c.getId()))
                return true;
        return false;
    }

    public List<Visite> getVisiteList() {
        return visiteList;
    }

    public void setVisiteList(List<Visite> visiteList) {
        this.visiteList = visiteList;
    }

    public void addVisite(Visite visite) {
        this.visiteList.add(visite);
    }

    public boolean hasVisite(Visite v) {
        for (Visite visite : this.visiteList)
            if (visite.getId().equals(v.getId()))
                return true;
        return false;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id='" + id + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", caches=" + caches +
                ", visiteList=" + visiteList +
                '}';
    }
}
