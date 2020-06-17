package news.services.interfaces;

import news.models.Tag;
import news.services.models.TagServiceModel;

public interface TagService {
    void saveTag(TagServiceModel tag);
    long getTagCount();
}
