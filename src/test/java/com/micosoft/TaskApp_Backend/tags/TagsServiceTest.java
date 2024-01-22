package com.micosoft.TaskApp_Backend.tags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TagsServiceTest {
    @Mock
    TagsRepository tagsRepository;
    @InjectMocks
    TagsService tagsService;

    Tags tag;

    @BeforeEach
    void setUp() {
        tag= Tags.builder().tagName("React").colors("#FFFF").build();
    }
    @Test
    void checkingIfAllTagsBeingBroughtFromDb(){
        tagsService.getTags();
        verify(tagsRepository).findAll();
    }

}