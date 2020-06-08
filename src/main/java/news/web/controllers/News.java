package news.web.controllers;

import java.util.List;

public class News {
    private List<String> text;

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
