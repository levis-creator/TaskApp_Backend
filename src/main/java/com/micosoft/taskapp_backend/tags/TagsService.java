package com.micosoft.taskapp_backend.tags;

import com.micosoft.taskapp_backend.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagsService {
    @Autowired
    TagsRepository tagsRepository;
    private final UserRepository userRepository;

    public List<Tags> getTags() {
        return tagsRepository.findAll();
    }

    public Tags getTag(String id) {
        Optional<Tags> tagDb = tagsRepository.findByTagNameIgnoreCase(id);
        if (tagDb.isPresent()){
            return tagDb.get();
        }else {
            throw new IllegalStateException("tag does not exist");
        }
        
    }

    public Tags createTag(Tags tags) {
        Optional<Tags> tagsDb= tagsRepository.findByTagNameIgnoreCase(tags.getTagName());
        if (tagsDb.isEmpty()){
            return tagsRepository.save(tags);
        }else {
            throw new IllegalStateException("Tag Does Not exists");
        }
    }

    public String deleteTag(String id) {
        Optional<Tags> tagsDb= tagsRepository.findByTagNameIgnoreCase(id);
        if (tagsDb.isPresent()){
            tagsRepository.deleteById(id);
            return "Deleted Successfully";
        }else {
            throw new IllegalStateException("Tag does not exists");
        }
    }

    public Tags updateTag(String id, Tags tags) {
        Optional<Tags> tagsDb=tagsRepository.findByTagNameIgnoreCase(id);
        if (tagsDb.isEmpty()){
            throw new IllegalStateException("Tag does not exist");

        }else if (!tags.getTagName().isEmpty()&&!tags.getTagName().equals(tagsDb.get().getTagName())){
            tagsDb.get().setTagName(tags.getTagName());
        }
        if (!tags.getColors().isEmpty()&&!tags.getColors().equals(tagsDb.get().getColors())){
            tagsDb.get().setColors(tags.getColors());
        }
        return tagsRepository.save(tagsDb.get());

    }
}
