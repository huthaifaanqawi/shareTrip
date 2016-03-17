package edu.mum.shareTrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Book;
import edu.mum.shareTrip.repository.BookRepository;
import edu.mum.shareTrip.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book newBook) {
		return bookRepository.save(newBook);
	}

	@Override
	public List<Book> getAllBooksByMemberId(long id) {
		return bookRepository.getAllBooksByMemberId(id);
	}

}
