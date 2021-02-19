package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Document
public class Visite {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "date_passage")
    private Date date_passage;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "photo")
    private String photo;
    @ManyToOne
    @DBRef
    private Cache cache;
    @ManyToOne
    @DBRef
    private User utilisateur;

    public Visite() {
    }

    public Visite(Date date_passage, String commentaire, String photo) {
        this.date_passage = date_passage;
        this.commentaire = commentaire;
        this.photo = photo;
    }

    public Visite(String commentaire, String photo) {
        this.commentaire = commentaire;
        this.photo = photo;
        this.date_passage = new Date();
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User user) {
        this.utilisateur = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate_passage() {
        return date_passage;
    }

    public void setDate_passage(Date date_passage) {
        this.date_passage = date_passage;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "\n\tVisite{" +
                "id='" + id + '\'' +
                ", date_passage=" + date_passage +
                ", commentaire='" + commentaire + '\'' +
                ", photo='" + photo + '\'' +
                ", cache=" + (cache != null ? cache.getId() : "null") +
                ", user=" + (utilisateur != null ? utilisateur.getId() : "null") +
                '}';
    }
}
