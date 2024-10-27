package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowContentByDayDTO;
import com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiabackend.dtos.queries.UrlDTO;
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
  @Override
  public List<ShowContentByFilterDTO> listContentByTitle(String title){
    return contentRepository.listContentByTitle(title);
  }
  @Override
  public List<ShowContentByFilterDTO> listContentByTypes(String type) {
    return contentRepository.listContentByTypes(type);
  }
  @Override
  public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc(){
    return contentRepository.listContentOrderByDateOfPublicationAsc();
  }

  @Override
  public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc(){
    return contentRepository.listContentOrderByDateOfPublicationDesc();
  }
  @Override
  public List<UrlDTO> listContentByLink(String title) {
    return contentRepository.listContentByLink(title);
  }

  @Override
  public Content insertContent(Content content) {
    return contentRepository.save(content);
  }

  @Override
  public Content updateContent(Content content) {
    if(contentRepository.existsById(content.getId())){
      return contentRepository.save(content);
    }
    return null;
  }
}
