package de.neusta.notebookkotlinsimple.infrastructure.repository

import de.neusta.notebookkotlinsimple.domain.Note
import de.neusta.notebookkotlinsimple.domain.NoteRepository
import de.neusta.notebookkotlinsimple.infrastructure.repository.model.NoteEntity
import org.springframework.stereotype.Repository

@Repository
class NoteRepositoryImpl(private val noteJpaRepository: NoteJpaRepository) : NoteRepository {

    override fun store(note: Note) {
        noteJpaRepository.save(mapToEntity(note))
    }

    override fun findAll(): List<Note> {
        return noteJpaRepository.findAll()
            .map { noteEntity -> mapToDomain(noteEntity) }
    }

    private fun mapToDomain(noteEntity: NoteEntity): Note {
        return Note(noteEntity.id, noteEntity.creationDate, noteEntity.content)
    }

    private fun mapToEntity(note: Note): NoteEntity {
        return NoteEntity(note.id, note.creationDate, note.content)
    }
}