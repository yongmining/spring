package com.greedy.section01.fieldinjection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	
	public List<BookDTO> findAllBooks() {
		
		return bookDAO.findAllBooks();
	}
	
	public BookDTO findOneBookBySequence(int sequence) {
		
		return bookDAO.findOneBookBySequence(sequence);
	}
}
