package com.example.demo.service;

import com.example.demo.entity.Note;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService implements INoteService {
    private Map<Long, Note> mapOfNotes = new HashMap<>();

    @Override
    public Note add(Note note) {
        // Generate a unique long value using UUID
        long id = UUID.randomUUID().getLeastSignificantBits();
        note.setId(id);
        mapOfNotes.put(id, note);
        return note; // Return the added note instead of the return value of put()
    }

    @Override
    public Note getById(long id) {
        if(mapOfNotes.containsKey(id)){
            return mapOfNotes.get(id);
        } else {
            return null;
            //throw new RuntimeException("Not found!");
        }
    }

    @Override
    public List<Note> listAll() {
        return List.copyOf(mapOfNotes.values());
    }

    @Override
    public void update(Note note) {
        if(mapOfNotes.containsKey(note.getId())){
            mapOfNotes.put(note.getId(), note);
        } else {
            throw new RuntimeException("Not found!");
        }
    }

    @Override
    public void deleteById(long id) {
        if(mapOfNotes.containsKey(id)){
            mapOfNotes.remove(id);
        } else {
            throw new RuntimeException("Not found!");
        }
    }
}
