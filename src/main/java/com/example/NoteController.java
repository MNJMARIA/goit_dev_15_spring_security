package com.example;

import com.example.entity.Note;
import com.example.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteService.class);
    private final  NoteService noteService;

    @GetMapping(value = "/list")
    public List<Note> getListOfNotes(){
        /*ModelAndView result = new ModelAndView("note/list");
        result.addObject("list", ); // Передача списку нотаток в модель
        return result;*/
        return noteService.listAll();
    }

    @PostMapping(value = "/delete")
    public String deleteById(@RequestParam(name = "id") long id){
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public Note editNote(@RequestParam(name = "id") int id){
        return noteService.getById(id);
    }

    @PostMapping("/edit")
    public void editNote(@RequestBody  Note note){
        noteService.update(note);
    }
}
