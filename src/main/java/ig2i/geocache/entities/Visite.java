package ig2i.geocache.mysql.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Document
public class Visite {
    @Id
    private Long id;
    @Column(name = "date_passage")
    private Date date_passage;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "photo")
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
