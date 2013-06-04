package com.company.project

import grails.converters.JSON
import grails.converters.XML
//import grails.plugin.gson.converters.GSON

class BookController {
	//use like 
	//$curl -X GET http://localhost:8080/episode-002/book -H "Accept: application/json"
	//$curl -X GET http://localhost:8080/episode-002/book -H "Accept: application/xml"
	//browser http://localhost:8080/episode-002/book?format=xml
	//browser http://localhost:8080/episode-002/book?format=json
    def list() { 
        withFormat {
            xml {
                render Book.list() as XML
            }
            json {
                render Book.list() as JSON
            }
        }
    }
//curl -X GET http://localhost:8080/episode-002/book/22 -H "Accept: application/json"
    def show(Integer id) {
        def book = Book.get(id)
        if(book) {
            withFormat {
                xml {
                    render book as XML
                }
                json {
                    render book as JSON
                }
            }
        } else {
            render 'Book not found'
        }
    }
	//curl -X DELETE http://localhost:8080/episode-002/book/2 -H "Accept: application/json"
	def delete(Integer id) {
		def book = Book.get(id)
		if(book) {
			try{
				book.delete(flush: true)
			}catch(Exception e){
			render 'Can\'t delete the book'
			}
		} else {
			render 'Book not found'
		}
		redirect(action: "list")
		
		
	}
	//curl -X POST http://localhost:8080/episode-002/book -H "Accept: application/json" -d isbn=6666 -d title=otro%20libro
	
	def save() {
		def book = new Book(params)
		boolean posible;
		try{
			posible = book.save(flush: true)
			
		}catch(Exception e){
			render 'Can\'t save the book'
			return
		}
		
		if(! posible){
			render 'Can\'t save the book'
			return
		}
		
		redirect(action: "show", id: book.id)
	}
	
}
