package com.wslibrary.ws;

import java.util.ArrayList;
import java.util.List;

import com.wslibrary.ws.libraryservice.*;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LibraryServiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.wslibrary.com/ws/LibraryService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) throws Exception {
        ObjectFactory factory = new ObjectFactory();
        ResponseStatus status = factory.createResponseStatus();
        AddBookResponse response = factory.createAddBookResponse();
        status.setCode(200);
        status.setMessage("Book added successfully");
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse deleteBook(@RequestPayload DeleteBookRequest request) throws Exception {
        ObjectFactory factory = new ObjectFactory();
        ResponseStatus status = factory.createResponseStatus();
        DeleteBookResponse response = factory.createDeleteBookResponse();
        status.setCode(204);
        status.setMessage("Book deleted successfully");
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBooksRequest")
    @ResponsePayload
//    public GetBooksResponse getBooks() throws Exception {
//        ObjectFactory factory = new ObjectFactory();
//        GetBooksResponse response = factory.createGetBooksResponse();
//
//        List<BookType> books = getBooks();//request.getAuthor()
//
//        response.getBooks().addAll(books);
//        return response;
//    }
    public List<BookType> getBooks(@RequestPayload GetBooksRequest request) {
        GetBooksResponse response = new GetBooksResponse();
        // Populate the response object with books
        List<BookType> books = response.getBooks();
        return books;
    }
    private List<BookType> getBooks(String author) {
        List<BookType> books = new ArrayList<BookType>();

        BookType book1 = new BookType();
        book1.setId(1);
        book1.setTitle("Spring in Action");
        book1.setAuthor("Craig Walls");

        BookType book2 = new BookType();
        book2.setId(2);
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");

        if (author == null || author.isEmpty()) {
            books.add(book1);
            books.add(book2);
        } else {
            if (book1.getAuthor().equals(author)) {
                books.add(book1);
            }
            if (book2.getAuthor().equals(author)) {
                books.add(book2);
            }
        }

        return books;
    }
}
