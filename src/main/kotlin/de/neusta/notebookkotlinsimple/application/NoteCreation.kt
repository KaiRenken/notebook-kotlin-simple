package de.neusta.notebookkotlinsimple.application

import de.neusta.notebookkotlinsimple.domain.Note
import de.neusta.notebookkotlinsimple.domain.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteCreation(private val noteRepository: NoteRepository) {

    fun createNote(content: String): Note {
        val createdNote = Note(content = content)

        noteRepository.store(createdNote)

        return createdNote
    }
}