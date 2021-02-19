import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoteListComponent } from './note-list/note-list.component';
import { CreateNoteComponent } from './create-note/create-note.component';
import { FormsModule} from '@angular/forms';
import { UpdateNoteComponent } from './update-note/update-note.component';
import { NoteDetailsComponent } from './note-details/note-details.component'

@NgModule({
  declarations: [
    AppComponent,
    NoteListComponent,
    CreateNoteComponent,
    UpdateNoteComponent,
    NoteDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
