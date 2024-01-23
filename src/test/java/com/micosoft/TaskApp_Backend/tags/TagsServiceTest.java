package com.micosoft.TaskApp_Backend.tags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagsServiceTest {
    @Mock
    TagsRepository tagsRepository;
    @InjectMocks
    TagsService tagsService;

    Tags tag;
    String tagName = "React";

    @BeforeEach
    void setUp() {
        tag = Tags.builder().tagName("React").colors("#FFFF").build();
    }

    @Test
    void checkingIfAllTagsBeingBroughtFromDb() {
        tagsService.getTags();
        verify(tagsRepository).findAll();
    }

    @Test
    void gettingTagWhenExist() {
        when(tagsRepository.findById(tagName)).thenReturn(Optional.of(tag));
        assertThat(tagsService.getTag(tagName)).isNotNull();
    }

    @Test
    void gettingTagWhenDoesNotExist() {
        when(tagsRepository.findById(tag.getTagName())).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> tagsService.getTag(tagName));
    }

    @Test
    void creatingTagWhenExists() {
        when(tagsRepository.existsById(tag.getUserId())).thenReturn(true);
        assertThrows(IllegalStateException.class, () -> tagsService.createTag(tag));
        verify(tagsRepository, never()).save(any());
    }

    @Test
    void creatingTagWhenDoesNotExist() {
        when(tagsRepository.existsById(tag.getUserId())).thenReturn(false);
        tagsService.createTag(tag);
        verify(tagsRepository).save(tag);
    }

    @Test
    void deletingTagWhenTagDoesNotExist() {
        when(tagsRepository.findById(tagName)).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> tagsService.deleteTag(tagName));
        verify(tagsRepository, never()).deleteById(tagName);
    }

    @Test
    void deletingTagWhenTagExists() {
        when(tagsRepository.findById(tagName)).thenReturn(Optional.of(tag));
        assertThat(tagsService.deleteTag(tagName)).isNotNull();
        verify(tagsRepository).deleteById(tagName);
    }
    @Test
    void updatingTagWhenTagDoeNotExist(){
        when(tagsRepository.findById(tagName)).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class,()->tagsService.updateTag(tagName, tag));
        verify(tagsRepository, never()).save(any());
    }


}