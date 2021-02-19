import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NoteListComponent } from './note-list/note-list.component';
import { CreateNoteComponent } from './create-note/create-note.component';
import { UpdateNoteComponent } from './update-note/update-note.component';
import { NoteDetailsComponent } from './note-details/note-details.component';

const routes: Routes = [
  {path: 'notes', component: NoteListComponent},
  {path: 'create-note', component: CreateNoteComponent},
  {path: '', redirectTo: 'notes', pathMatch: 'full'},
  {path: 'update-note/:id', component: UpdateNoteComponent},
  {path: 'note-details/:id', component: NoteDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
