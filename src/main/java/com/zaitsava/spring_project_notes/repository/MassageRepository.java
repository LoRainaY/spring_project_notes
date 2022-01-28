package com.zaitsava.spring_project_notes.repository;

import com.zaitsava.spring_project_notes.entity.Message;
import com.zaitsava.spring_project_notes.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MassageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
    List<Message> findByAuthor(User user);

}