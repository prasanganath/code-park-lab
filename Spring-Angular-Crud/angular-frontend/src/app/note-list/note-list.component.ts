import { Component, OnInit } from '@angular/core';
import { Note } from '../note'
import { NoteService } from '../note.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-note-list',
  templateUrl: './note-list.component.html',
  styleUrls: ['./note-list.component.css']
})
export class NoteListComponent implements OnInit {

  notes: Note[];

  constructor(private noteService: NoteService,
    private router: Router) { }

  ngOnInit(): void {
    this.getNotes();
  }

  private getNotes(){
    this.noteService.getNotesList().subscribe(data => {
      this.notes = data;
    });
  }

  noteDetails(id: number){
    this.router.navigate(['note-details', id]);
  }

  updateNote(id: number){
    this.router.navigate(['update-note', id]);
  }

  deleteNote(id: number){
    this.noteService.deleteNote(id).subscribe( data => {
      console.log(data);
      this.getNotes();
    })
  }
}
