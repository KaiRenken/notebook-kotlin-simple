package de.neusta.notebookkotlinsimple.infrastructure.repository

import de.neusta.notebookkotlinsimple.infrastructure.repository.model.NoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteJpaRepository : JpaRepository<NoteEntity, UUID>