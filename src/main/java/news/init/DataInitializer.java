package news.init;

import news.models.dtos.CategoryDto;
import news.models.dtos.TagDto;
import news.services.interfaces.CategoryService;
import news.services.interfaces.NewsService;
import news.services.interfaces.TagService;
import news.services.interfaces.UserService;
import news.services.models.CategoryServiceModel;
import news.services.models.TagServiceModel;
import news.util.json.JsonParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final TagService tagService;
    private final CategoryService categoryService;
    private final NewsService newsService;
    private final ModelMapper modelMapper;

    @Autowired
    public DataInitializer(UserService userService, TagService tagService, CategoryService categoryService, NewsService newsService, ModelMapper modelMapper) {
        this.userService = userService;
        this.tagService = tagService;
        this.categoryService = categoryService;
        this.newsService = newsService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void run(String... args) throws Exception {

        JsonParser parser = new JsonParser();

        if (this.categoryService.getCategoryCount()==0) {
            CategoryDto[] categoryDto = parser.objectFromFile(CategoryDto[].class,"src/main/java/news/init/jsons/categories.json");

            Arrays.stream(categoryDto)
                    .map(c->this.modelMapper.map(c, CategoryServiceModel.class))
                    .forEach(this.categoryService::saveCategory);
        }

        if (this.tagService.getTagCount()==0){
            TagDto[] tagDto = parser.objectFromFile(TagDto[].class,"src/main/java/news/init/jsons/tags.json");

            Arrays.stream(tagDto)
                    .map(t->this.modelMapper.map(t, TagServiceModel.class))
                    .forEach(this.tagService::saveTag);
        }

        System.out.println();
    }
}
