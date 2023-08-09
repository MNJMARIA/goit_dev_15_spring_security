package com.example.service;

import com.example.entity.Note;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Data
@Service
public class NoteService implements INoteService {
    private Map<Long, Note> mapOfNotes = new HashMap<>();

    @Override
    public Note add(Note note) {
        // Generate a unique long value using UUID
        long id = new Random().nextLong();
        note.setId(id);
        mapOfNotes.put(note.getId(), note);
        return note; // Return the added note instead of the return value of put()
    }

    @Override
    public Note getById(long id) {
        if(mapOfNotes.containsKey(id)){
            Note note = mapOfNotes.get(id);
            return note;
        } else {
            throw new NullPointerException("Not found!");
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
            throw new NullPointerException("Not found!");
        }
    }

    @Override
    public void deleteById(long id) {
        if(mapOfNotes.containsKey(id)){
            mapOfNotes.remove(id);
        } else {
            throw new NullPointerException("Not found!");
        }
    }
}
