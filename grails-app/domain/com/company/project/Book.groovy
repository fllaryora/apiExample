package com.company.project

class Book {
    String title
    String isbn
    
    static constraints = {
		isbn blank:false, nullable:false, unique:true
		title blank:false, nullable:false, unique:true
    }
}
