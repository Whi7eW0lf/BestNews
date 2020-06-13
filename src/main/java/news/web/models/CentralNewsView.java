package news.web.models;

import java.time.LocalDateTime;

public class CentralNewsView {
    private String id;
    private String imageUrl;
    private String category;
    private String title;
    private String authorNames;
    private LocalDateTime date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
