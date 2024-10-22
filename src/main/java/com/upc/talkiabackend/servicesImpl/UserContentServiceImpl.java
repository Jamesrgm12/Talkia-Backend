package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Content;
import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.entities.UserContent;
import com.upc.talkiabackend.repositories.ContentRepository;
import com.upc.talkiabackend.repositories.UserContentRepository;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserContentServiceImpl implements UserContentService {

    @Autowired
    UserContentRepository userContentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentRepository contentRepository;

    @Transactional
    @Override
    public Integer insertUserContent(Integer contentId, Integer userId) {
        User user = userRepository.findById(userId).get();
        Content content = contentRepository.findById(contentId).get();
        UserContent userContent = new UserContent();

        userContent.setUser(user);
        userContent.setContent(content);
        userContentRepository.save(userContent);
        return 1;
    }
}
