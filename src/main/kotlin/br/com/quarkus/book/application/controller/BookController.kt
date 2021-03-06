package br.com.quarkus.book.application.controller

import br.com.quarkus.book.application.controller.data.ResultResponseData
import br.com.quarkus.book.domain.Book
import br.com.quarkus.book.service.BookService
import javax.inject.Inject
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.Validator
import javax.ws.rs.POST
import javax.ws.rs.Path


@Path("/book")
class BookController {

    @Inject
    lateinit var validator: Validator

    @Inject
    lateinit var bookService: BookService

    @Path("/manual-validation")
    @POST
    fun tryManualValidation(book: Book): ResultResponseData {
        val violations: Set<ConstraintViolation<Book>> = validator.validate(book)
        return if (violations.isEmpty()) {
            ResultResponseData("Book is valid! It was validated by manual validation.")
        } else {
            ResultResponseData(violations)
        }
    }

    @Path("/end-point-method-validation")
    @POST
    fun tryMeEndPointMethodValidation(@Valid book: Book) =
        ResultResponseData("Book is valid! It was validated by manual validation.")

    @Path("/service-method-validation")
    @POST
    fun tryMeServiceMethodValidation(book: Book): ResultResponseData {
        return try {
            bookService.validateBook(book)
            ResultResponseData("Book is valid! It was validated by service method validation.")
        } catch (e: ConstraintViolationException) {
            ResultResponseData(e.constraintViolations)
        }
    }
}
