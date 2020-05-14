package news.data.models;

import java.time.LocalDate;
import java.util.List;

public class News {

    private Author author;
    private LocalDate localDate;
    private Comment comment;
    private Integer views;
    private Integer countComments;
    private String title;
    private String textNews;
    private String imageLink;
    private List<String> tags;

}
