package br.com.quarkus.book.domain

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class Book(
    @NotBlank(message = "Title may not be blank")
    val title: String,

    @NotBlank(message = "Author may not be blank")
    val author: String,

    @Min(message = "Author has been very lazy", value = 1)
    val pages: Int
)
