package de.neusta.notebookkotlinsimple.infrastructure.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.*

@Entity
class NoteEntity(

    @Id
    val id: UUID,

    val creationDate: LocalDateTime,

    val content: String,
)