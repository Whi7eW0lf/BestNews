package news.services.interfaces;

import news.services.models.CategoryServiceModel;

public interface CategoryService {
    CategoryServiceModel getCategoryByType(String type);
}
