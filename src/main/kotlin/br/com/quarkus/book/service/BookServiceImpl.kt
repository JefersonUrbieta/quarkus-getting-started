package br.com.quarkus.book.service

import br.com.quarkus.book.domain.Book
import javax.enterprise.context.ApplicationScoped
import javax.validation.Valid

@ApplicationScoped
class BookServiceImpl : BookService {
    override fun validateBook(@Valid book: Book) {
        // Do something
    }
}
