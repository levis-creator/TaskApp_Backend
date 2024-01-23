package com.micosoft.TaskApp_Backend.tags;

import com.micosoft.TaskApp_Backend.users.User;
import com.micosoft.TaskApp_Backend.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagsService {
    TagsRepository tagsRepository;
    private final UserRepository userRepository;

    public List<Tags> getTags() {
        return tagsRepository.findAll();
    }

    public Tags getTag(String id) {
        Optional<Tags> tagDb = tagsRepository.findById(id);
        if (tagDb.isPresent()){
            return tagDb.get();
        }else {
            throw new IllegalStateException("tag does not exist");
        }
        
    }

    public Tags createTag(Tags tags) {
        boolean tagsDb= tagsRepository.existsById(tags.getUserId());
        if (!tagsDb){
            return tagsRepository.save(tags);
        }else {
            throw new IllegalStateException("Tag Does Not exists");
        }
    }

    public String deleteTag(String id) {
        Optional<Tags> tagsDb= tagsRepository.findById(id);
        if (tagsDb.isPresent()){
            tagsRepository.deleteById(id);
            return "Deleted Successfully";
        }else {
            throw new IllegalStateException("Tag does not exists");
        }
    }

    public Tags updateTag(String id, Tags tags) {
        Optional<Tags> tagsDb=tagsRepository.findById(id);
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
