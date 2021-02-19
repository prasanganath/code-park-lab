import { Component, OnInit } from '@angular/core';
import { NoteService } from '../note.service';
import { Note } from '../note';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-note',
  templateUrl: './update-note.component.html',
  styleUrls: ['./update-note.component.css']
})
export class UpdateNoteComponent implements OnInit {

  id: number;
  note: Note = new Note();
  constructor(private noteService: NoteService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.noteService.getNoteById(this.id).subscribe(data => {
      this.note = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.noteService.updateNote(this.id, this.note).subscribe( data =>{
      this.goToNoteList();
    }
    , error => console.log(error));
  }

  goToNoteList(){
    this.router.navigate(['/notes']);
  }
}
