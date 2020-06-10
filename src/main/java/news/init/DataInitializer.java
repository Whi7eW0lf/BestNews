package news.init;

import news.models.*;
import news.repositories.CategoryRepository;
import news.repositories.NewsRepository;
import news.repositories.TagRepository;
import news.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository; //TODO: Service
    private final TagRepository tagRepository; //TODO: Service
    private final CategoryRepository categoryRepository; //TODO: Service
    private final NewsRepository newsRepository; //TODO: Service
    private User user;
    private Tag tag;
    private Category category;
    private News news;

    @Autowired
    public DataInitializer(UserRepository userRepository, TagRepository tagRepository, CategoryRepository categoryRepository, NewsRepository newsRepository) {
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.categoryRepository = categoryRepository;
        this.newsRepository = newsRepository;
        this.user = new User();
        this.tag = new Tag();
        this.category = new Category();
        this.news = new News();
    }

    public void addNews(){
        this.news.setImageUrl("/images/test-image-1000x466.jpg");
        this.news.setDate(LocalDateTime.now());
        this.news.setCategory(this.category);
        this.news.setUser(this.user);
        Random random = new Random();
        this.news.setViews(Math.abs(random.nextInt()));
        this.news.setTextNews("NULL");
        this.news.setTitle("Test database text");
        this.news.setTags(Collections.singletonList(this.tag));
        this.newsRepository.saveAndFlush(this.news);
    }

    public void addCategory(){
        this.category.setType("Random");
        this.categoryRepository.saveAndFlush(this.category);

    }

    public void addTag(){
        this.tag.setTag("TestTag");
        this.tagRepository.saveAndFlush(tag);
    }

    public void addUser(){


        this.user.setFirstName("Salih");
        this.user.setLastName("Musov");
        this.user.setIp("11.11.11.11");
        this.user.setRole(Role.ADMINISTRATOR);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count()<1
                &&this.newsRepository.count()<1
                &&this.tagRepository.count()<1
                &&this.userRepository.count()<1){
            for (int i = 0; i < 10; i++) {
                this.user = new User();
                this.tag = new Tag();
                this.category = new Category();
                this.news = new News();

                this.addUser();
                this.addCategory();
                this.addTag();
                this.addNews();
            }
        }
    }
}
