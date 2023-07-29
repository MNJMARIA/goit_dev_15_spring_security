package com.example.demo;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

public class NoteServiceTests {
    private NoteService noteService;

    @BeforeEach
    public void beforeEach(){
        noteService = new NoteService();
    }

    @AfterEach
    public void afterEach() {
        noteService = null;
    }

    @Test
    public void testCreateNoteWorksOk(){
        Note note = new Note();
        note.setTitle("Created Title");
        note.setContent("Created Content");

        Note createdNote = noteService.add(note);

        Assertions.assertNotNull(createdNote.getId());
        Assertions.assertEquals(note.getTitle(), createdNote.getTitle());
        Assertions.assertEquals(note.getContent(), createdNote.getContent());

        // Clean up
        //noteService.deleteById(createdNote.getId());
    }

    @Test
    public void testGetNoteById1WorksOk(){
        Note note = new Note();
        note.setTitle("Created Title");
        note.setContent("Created Content");

        Note createdNote = noteService.add(note);
        long existingNoteId = createdNote.getId();

        Note actualNote = noteService.getById(existingNoteId);

        Assertions.assertNotNull(actualNote);
        Assertions.assertEquals(note.getTitle(), actualNote.getTitle());
        Assertions.assertEquals(note.getContent(), actualNote.getContent());
    }

    @Test
    public void testGetNoteByNotExistIdWorksOk(){
        Note note = new Note();
        note.setTitle("Created Title");
        note.setContent("Created Content");

        noteService.add(note);

        Assertions.assertThrows(NullPointerException.class, () -> noteService.getById(10000L));
    }

    @Test
    public void testGetAllNotesWorksOk(){
        List<Note> notes = noteService.listAll();

        Assertions.assertNotNull(notes);

        // Check if there are no one note (no database)
        Assertions.assertTrue(notes.isEmpty());
    }

    @Test
    public void testUpdateClientWorksOk(){
        Note note = new Note();
        note.setTitle("Created Title");
        note.setContent("Created Content");

        Note createdNote = noteService.add(note);
        long existingNoteId = createdNote.getId();

        Note newNote = new Note();
        newNote.setId(existingNoteId);
        newNote.setTitle("New Title");
        newNote.setContent("New Content");

        noteService.update(newNote);

        Note updatedNote = noteService.getById(existingNoteId);

        Assertions.assertNotNull(updatedNote);
        Assertions.assertEquals(newNote.getTitle(), updatedNote.getTitle());
        Assertions.assertEquals(newNote.getContent(), updatedNote.getContent());
    }

    @Test
    public void testDeleteClientWorksOk(){
        Note note = new Note();
        note.setTitle("To Delete Title");
        note.setContent("To Delete Content");

        Note noteToDelete = noteService.add(note);

        noteService.deleteById(noteToDelete.getId());

        Assertions.assertThrows(NullPointerException.class, () -> noteService.getById(noteToDelete.getId()));
    }
}
