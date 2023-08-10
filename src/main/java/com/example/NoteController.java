package com.example;

import com.example.entity.Note;
import com.example.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public void deleteById(@RequestParam(name = "id") long id){
        noteService.deleteById(id);
        //return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public Note editNote(@RequestParam(name = "id") long id){
        //another variant is to use: @PathVariable Long id
        return noteService.getById(id);
    }

    @PostMapping("/edit")
    public void editNote(@RequestBody  Note note){
        noteService.update(note);
    }
}
