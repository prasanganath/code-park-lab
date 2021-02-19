package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long>{

}
