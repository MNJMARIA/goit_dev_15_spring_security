package com.example.note;

import com.example.note.Note;
import com.example.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    // в реальній розробці не використовують System.out.println(),
    // а використовують Logger для виводу інформації в консоль
    private static final Logger logger = LoggerFactory.getLogger(NoteService.class);
    private final  NoteService noteService;

    @PostMapping(value = "/create")
    public Note createNote(@RequestBody Note note){
        return noteService.add(note);
    }

    @GetMapping(value = "/list")
    public List<Note> getListOfNotes(){
        return noteService.listAll();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") long id){
        Note existingNote = noteService.getById(id);
        if(existingNote == null){
            return ResponseEntity.notFound().build();
        }
        noteService.deleteById(id);
        return ResponseEntity.ok("Note deleted successfully");
        //return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ResponseEntity<Note> editNote(@RequestParam(name = "id") long id){
        //another variant is to use: @PathVariable Long id
        Note existingNote = noteService.getById(id);
        if (existingNote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(existingNote);
    }


    //OR @PostMapping for update
    @PutMapping("/edit")
    public ResponseEntity<String> editNote(@RequestBody  Note note){
        Note existingNote = noteService.getById(note.getId());
        if (existingNote == null) {
            return ResponseEntity.notFound().build();
        }
        noteService.update(note);
        return ResponseEntity.ok("Note updated successfully");

    }
}
