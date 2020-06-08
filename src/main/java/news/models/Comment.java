package news.models;

import javax.persistence.*;

@Table
@Entity
public class Comment extends BaseEntity{

    private String name;
    private String email;
    private String comment;

    @Column(name = "username")
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "comment",columnDefinition = "MEDIUMTEXT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
