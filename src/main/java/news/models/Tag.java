package news.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tags")
@Entity
public class Tag extends BaseEntity{
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
