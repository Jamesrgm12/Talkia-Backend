package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO;

import java.util.List;

public interface ContentService {
  public List<ShowContentByFilterDTO> listContentByLevels(String level);
}
