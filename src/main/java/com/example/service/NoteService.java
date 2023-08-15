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
    //private Map<Long, Note> mapOfNotes = new HashMap<>();

    @Override
    public Note add(Note note) {
        return repository.save(note);
        
        /*// Generate a unique long value using UUID
        long id = new Random().nextLong();
        note.setId(id);
        mapOfNotes.put(note.getId(), note);
        return note; // Return the added note instead of the return value of put()
        */
    }

    @Override
    public Note getById(long id) {
        Optional<Note> noteOptional = repository.findById(id);
        return noteOptional.orElseThrow(() -> new NoSuchElementException("Note not found!"));

        
        /*if(mapOfNotes.containsKey(id)){
            Note note = mapOfNotes.get(id);
            return note;
        } else {
            throw new NullPointerException("Not found!");
        }*/
    }

    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public void update(Note note) {
        repository.save(note);
        /*if(mapOfNotes.containsKey(note.getId())){
            mapOfNotes.put(note.getId(), note);
        } else {
            throw new NullPointerException("Not found!");
        }*/
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
        /*if(mapOfNotes.containsKey(id)){
            mapOfNotes.remove(id);
        } else {
            throw new NullPointerException("Not found!");
        }*/
    }
}
