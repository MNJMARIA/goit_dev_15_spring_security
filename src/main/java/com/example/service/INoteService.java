package com.example.service;

import com.example.entity.Note;

import java.util.List;

public interface INoteService {
    Note add(Note note);
    Note getById(long id);
    List<Note> listAll();
    void update(Note note);
    void deleteById(long id);
}
