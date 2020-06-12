package news.services.implementations;

import news.repositories.CategoryRepository;
import news.services.interfaces.CategoryService;
import news.services.models.CategoryServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryServiceModel getCategoryByType(String type) {
        return this.modelMapper.map(this.categoryRepository.findCategoryByType(type),CategoryServiceModel.class);
    }
}
