package br.com.quarkus.book.application.controller.data

import java.util.stream.Collectors
import javax.validation.ConstraintViolation


class ResultResponseData(
    val message: String,
    val success: Boolean = true
) {
    constructor(violations: Set<ConstraintViolation<*>>) : this(
        message = violations
            .stream()
            .map { it.message }
            .collect(Collectors.joining(", ")),
        success = false
    )
}
