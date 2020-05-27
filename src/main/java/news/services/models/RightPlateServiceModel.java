package news.services.models;

public class RightPlateServiceModel {

    private String imgUrl;
    private String category;
    private String title;


    /**
     * Image must be size 1000x743 or 1000x466 for perfect view.
     */

    public String getImgUrl() {
        return imgUrl;
    }

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
}
