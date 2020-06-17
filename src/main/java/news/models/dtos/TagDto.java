package news.models.dtos;

import com.google.gson.annotations.Expose;

public class TagDto {

    @Expose
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
