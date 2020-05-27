package news.services.models;

public class CentralPlateServiceModel {

    private String imgUrl;
    private String category;
    private String title;
    private String Author;
    private String date;

    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Image must be size 1000x840 for perfect view.
     */

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
