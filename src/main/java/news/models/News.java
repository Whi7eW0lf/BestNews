package news.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "news")
@Entity
public class News extends BaseEntity{

    private User user;
    private LocalDateTime date;
    private List<Comment> comments;
    private Integer views;
    private String title;
    private String textNews;
    private String imageLink;
    private Set<Tag> tags;
    private Set<Category> category;

    @OneToMany
    @JoinColumn(name = "category_id")
    public Set<Category> getCategory() {
        return category;
    }

    @OneToMany
    @JoinColumn(name = "tag_id")
    public Set<Tag> getTags() {
        return tags;
    }

    @OneToMany
    @JoinColumn(name = "comment_id")
    public List<Comment> getComments() {
        return comments;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "date")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public void setComments(List<Comment> comment) {
        this.comments = comment;
    }

    @Column(name = "views")
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "text",columnDefinition = "MEDIUMTEXT")
    public String getTextNews() {
        return textNews;
    }

    public void setTextNews(String textNews) {
        this.textNews = textNews;
    }

    @Column(name = "image_url")
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }


    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
