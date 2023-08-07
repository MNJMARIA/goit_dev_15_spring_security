package com.example.demo;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    NoteService noteService = new NoteService();

    @GetMapping(value = "/list")
    public ModelAndView getListOfNotes(){
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("list", noteService.listAll()); // Передача списку нотаток в модель
        return result;
    }

    @PostMapping(value = "/delete")
    public String deleteById(@RequestParam(name = "id") long id){
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam(name = "id") int id){
        ModelAndView result = new ModelAndView("edit");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

    /*@PostMapping(value = "/edit")
    public ModelAndView editNote(){
        ModelAndView result = new ModelAndView();
        result.addObject("test");
        return result;
    }*/
    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note){
        noteService.update(note);
        return "redirect:/note/list";
    }
}
