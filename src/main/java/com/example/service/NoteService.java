package com.example.service;

import com.example.NoteRepository;
import com.example.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService implements INoteService {
    private final NoteRepository repository;

    @Override
    public Note add(Note note) {
        return repository.save(note);
    }

    @Override
    public Note getById(long id) {
        Optional<Note> noteOptional = repository.findById(id);
        return noteOptional.orElseThrow(() -> new NoSuchElementException("Note not found!"));
    }

    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public void update(Note note) {
        repository.save(note);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
