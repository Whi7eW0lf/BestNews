package news.services.implementations;

import news.models.Tag;
import news.repositories.TagRepository;
import news.services.interfaces.TagService;
import news.services.models.TagServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveTag(TagServiceModel tag) {
        this.tagRepository.saveAndFlush(this.modelMapper.map(tag, Tag.class));
    }

    @Override
    public long getTagCount() {
        return this.tagRepository.count();
    }
}
