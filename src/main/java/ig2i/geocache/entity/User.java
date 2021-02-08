package ig2i.geocache.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Document(collection = "user")
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

    public User() {
    }

    public User(String pseudo, String photo, String description) {
        this.pseudo = pseudo;
        this.photo = photo;
        this.description = description;
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
        return "User{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
