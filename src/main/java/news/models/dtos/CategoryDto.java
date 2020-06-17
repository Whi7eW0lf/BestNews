package news.models.dtos;

import com.google.gson.annotations.Expose;

public class CategoryDto {
    @Expose
    private String type;

    public CategoryDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
