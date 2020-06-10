package news.models;

import javax.persistence.*;

@Table(name = "tags")
@Entity
public class Tag extends BaseEntity{
    private String tag;
    private News news;

    public void setNews(News news) {
        this.news = news;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
