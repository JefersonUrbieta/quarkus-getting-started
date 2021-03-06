package br.com.quarkus.book.service

import br.com.quarkus.book.domain.Book
import javax.validation.Valid

interface BookService {
    fun validateBook(@Valid book: Book)
}
