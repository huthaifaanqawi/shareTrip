package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Book;

public interface BookService {

	public Book saveBook(Book newBook);
	
	public List<Book> getAllBooksByMemberId(long id);
}
