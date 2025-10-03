package com.book.booklibrarymanagement.exception;

import com.book.booklibrarymanagement.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BooksExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
public ResponseEntity<ResponseStructure<String>>handleBNFE(BookNotFoundException exception) {
    ResponseStructure<String> structure = new ResponseStructure<>();
    structure .setMessage(exception.getMessage());
    structure.setStatusCode(HttpStatus.NOT_FOUND.value());
    structure.setData("books not found");
    return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
}
}
