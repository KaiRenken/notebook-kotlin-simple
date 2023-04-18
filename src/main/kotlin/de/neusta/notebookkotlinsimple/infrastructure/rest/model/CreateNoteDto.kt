package de.neusta.notebookkotlinsimple.infrastructure.rest.model

import com.fasterxml.jackson.annotation.JsonProperty

class CreateNoteDto(
    @JsonProperty(required = true) val content: String,
)