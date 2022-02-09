package com.liam.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.lookify.models.Song;
import com.liam.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
	
    public List<Song> allSongs() {
        return songRepo.findAll();
    }
    
    public Song findSong(Long id) {
    	return songRepo.findById(id).orElse(null);

    }
    

    public Song createSong(Song lang) {
        return songRepo.save(lang);
    }
    

    public Song updateSong(Song lang) {
        return songRepo.save(lang);
    }

    	
    public void deleteSong(Long Id) {
    	songRepo.deleteById(Id);
    	}
    
	public List<Song> findSongs(String title) {
		return songRepo.findByTitleContaining(title);
	
	}
	
	   public List<Song> allTopSongs() {
	        return songRepo.findTop10ByOrderByRatingDesc();
	    }


    }



