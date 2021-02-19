package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Notes;
import net.javaguides.springboot.repository.NoteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	
	// get all employees
	@GetMapping("/notes")
	public List<Notes> getAllNotes(){
		return noteRepository.findAll();
	}	
	
	
	// create employee 
	@PostMapping("/notes")
	public Notes createNotes(@RequestBody Notes note) {
		return noteRepository.save(note);
	}
	
	
	// get employee
	@GetMapping("/notes/{id}")
	public ResponseEntity<Notes> getNoteById(@PathVariable Long id) {
		Notes note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exist with id :" + id));
		return ResponseEntity.ok(note);
	}
	
	// update employee
	@PutMapping("/notes/{id}")
	public ResponseEntity<Notes> updateNote(@PathVariable Long id, @RequestBody Notes noteDetails){
		Notes note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exist with id :" + id));
		
		note.setAuther(noteDetails.getAuther());
		note.setFirstPar(noteDetails.getFirstPar());
		note.setLastPar(noteDetails.getLastPar());
		
		Notes updatedNote = noteRepository.save(note);
		return ResponseEntity.ok(updatedNote);
	}
	
	// delete employee
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNotes(@PathVariable Long id){
		Notes note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exist with id :" + id));
		
		noteRepository.delete(note);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
