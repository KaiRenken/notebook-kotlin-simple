package de.neusta.notebookkotlinsimple.application

import de.neusta.notebookkotlinsimple.domain.NoteRepository
import de.neusta.notebookkotlinsimple.testdatafactories.NoteTestDataFactory.Companion.aTestNote
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class NoteCreationTest {

    private val noteRepositoryMock: NoteRepository = mockk()

    private val noteCreationToTest = NoteCreation(noteRepositoryMock)

    @Test
    fun createNote() {
        val testNote = aTestNote().build()
        every { noteRepositoryMock.store(any()) }.returns(testNote)

        val result = noteCreationToTest.createNote(testNote.content)

        assertThat(result.creationDate).isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.SECONDS))
        assertThat(result.content).isEqualTo("test-content")
    }
}