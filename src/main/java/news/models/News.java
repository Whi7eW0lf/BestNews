package news.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "news")
@Entity
public class News extends BaseEntity{

    private User user;
    private LocalDateTime date;
    private Integer views;
    private String title;
    private String textNews;
    private String imageUrl;
    private List<Tag> tags;
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany
    @JoinColumn(name = "news_id")
    public List<Tag> getTags() {
        return tags;
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
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
