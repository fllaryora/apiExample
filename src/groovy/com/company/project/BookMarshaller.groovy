package com.company.project

import grails.converters.JSON

class BookMarshaller {
    void register() {
        JSON.registerObjectMarshaller(Book) { Book book ->
         return [
            name: book.title,
            isbn: book.isbn
         ]
        }
    }
}