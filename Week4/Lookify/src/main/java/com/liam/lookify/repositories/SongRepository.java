package com.liam.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.liam.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
  List<Song> findAll();
    
    
  // this method finds books with descriptions containing the search string
  List<Song> findByTitleContaining(String title);
  
  List<Song> findTop10ByOrderByRatingDesc();
  
//  // this method counts how many titles contain a certain string
//  Long countByTitleContaining(String search);
//  // this method deletes a book that starts with a specific title
//  Long deleteByTitleStartingWith(String search);

}
