package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelService {
  public List<Level> listLevels();
}
