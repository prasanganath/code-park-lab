import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
import { ActivatedRoute } from '@angular/router';
import { NoteService } from '../note.service';

@Component({
  selector: 'app-note-details',
  templateUrl: './note-details.component.html',
  styleUrls: ['./note-details.component.css']
})
export class NoteDetailsComponent implements OnInit {

  id: number
  note: Note
  constructor(private route: ActivatedRoute, private noteService: NoteService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.note = new Note();
    this.noteService.getNoteById(this.id).subscribe( data => {
      this.note = data;
    });
  }

}
