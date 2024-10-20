package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiabackend.entities.Content;
import com.upc.talkiabackend.repositories.ContentRepository;
import com.upc.talkiabackend.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
  @Autowired
  private ContentRepository contentRepository;
  @Override
  public List<ShowContentByFilterDTO> listContentByLevels(String level) {
    return contentRepository.listContentByLevels(level);
  }
  @Override
  public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(String level, String type) {
    return contentRepository.listContentByLevelsAndTypes(level, type);
  }
  @Override
  public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(String level, String theme) {
    return contentRepository.listContentByLevelsAndTheme(level, theme);
  }
  @Override
  public List<Content> listAllContent() {
    return contentRepository.findAll();
  }
}
