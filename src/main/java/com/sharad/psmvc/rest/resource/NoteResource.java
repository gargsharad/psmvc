package com.sharad.psmvc.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sharad.psmvc.service.NotesService;
import com.welflex.notes.exception.NoteNotFoundException;
import com.welflex.notes.jaxb.Note;

public class NoteResource {
  
  private final NotesService notesService;
  
  @Inject
  public NoteResource(NotesService notesService) {
    this.notesService = notesService;
  }
  
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Note get(@PathParam("noteId") Long noteId) throws NoteNotFoundException {

    Note note = notesService.get(noteId);
    
    if (note == null) {
      throw new NoteNotFoundException("Not found:" + noteId);
    }
    
    return note;
  }

  @PUT
  public void update(@PathParam("noteId") Long noteId, Note note) {
    notesService.update(noteId, note);
  }

  @DELETE
  public void delete(@PathParam("noteId") Long noteId) {
    notesService.delete(noteId);
  }
}
