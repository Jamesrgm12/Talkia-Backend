package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowContentByDayDTO;
import com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiabackend.dtos.queries.UrlDTO;
import com.upc.talkiabackend.entities.Content;

import java.util.List;

public interface ContentService {
  public List<ShowContentByFilterDTO> listContentByLevels(String level);
  public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(String level, String type);
  public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(String level, String theme);
  public List<Content> listAllContent();
  public List<ShowContentByFilterDTO> listContentByTitle(String title);
  public List<ShowContentByFilterDTO> listContentByTypes(String type);
  public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc();
  public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc();
  public Content insertContent(Content content);
  public List<UrlDTO> listContentByLink(String title);
  public Content updateContent(Content content);
  public void deleteContent(int id);

}
