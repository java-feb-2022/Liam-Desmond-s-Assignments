package com.liam.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liam.lookify.models.Song;
import com.liam.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songServ;
	
	// Get All
    @RequestMapping("/songs")
    public String index(@ModelAttribute("song") Song song, Model model) {
        List<Song> songs = songServ.allSongs();
        model.addAttribute("songs", songs);
        return "/songs/index.jsp";
    }
    
    // Get One
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song = songServ.findSong(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }
    
    // Create Form PAGE
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }

    // Create Processing
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
            return "/songs/new.jsp";
//            List<Song> songs = songServ.allSongs();
//            model.addAttribute("songs", songs);
//            return "/songs/index.jsp";
        } else {
        	songServ.createSong(song);
            return "redirect:/songs";
        }
    }
    
    // Edit Form
    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Song song = songServ.findSong(id);
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }
    
    // Edit Processing
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
        	return "/songs/edit.jsp";

        } else {
        	songServ.updateSong(song);
            return "redirect:/songs";
        }
    }
    
    
    // Delete
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songServ.deleteSong(id);
        return "redirect:/songs";
    }
    
    
    
    
    //!!!!!!!!!!!!!!SEARCH ROUTES!!!!!!!!!!!!!!!!!
    
    
    @RequestMapping("/search")
    public String search(@ModelAttribute("song") Song song) {
    	return "/songs/search.jsp";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String searching(@RequestParam("title") String title, @ModelAttribute("song") Song song, Model model) {
    	List<Song> songs = songServ.findSongs(title);
        model.addAttribute("songs", songs);
        System.out.println(songs);
        return "/songs/search.jsp";
    }
    
	// Get All
    @RequestMapping("/top")
    public String topTen( Model model) {
        List<Song> songs = songServ.allTopSongs();
        System.out.println(songs);
        model.addAttribute("songs", songs);
        return "/songs/top.jsp";
    }

}
