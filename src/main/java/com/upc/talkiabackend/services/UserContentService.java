package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiabackend.dtos.queries.ShowHistorialContentDTO;

import java.util.List;

public interface UserContentService {
    public Integer insertUserContent(Integer contentId, Integer userId);
    public List<ShowHistorialContentDTO> listUserContent();
    public List<ShowContentHistoryDTO> ListUserContentByUser(int userId);
}
