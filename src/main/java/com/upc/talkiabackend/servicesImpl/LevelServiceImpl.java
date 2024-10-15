package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.repositories.LevelRepository;
import com.upc.talkiabackend.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
  @Autowired
  private LevelRepository levelRepository;
  @Override
  public List<Level> listLevels() {
    return levelRepository.findAll();
  }
}
