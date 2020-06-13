package news.web.models;

import java.time.LocalDateTime;

public class LatestArticlesView {
    private String title;
    private String authorNames;
    private String imageUrl;
    private String id;
    private LocalDateTime date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
