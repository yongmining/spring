package com.greedy.section01.fieldinjection;

import java.util.List;

public interface BookDAO {

	
	/* 도서 목록 전체 조회 */
	List<BookDTO> findAllBooks();
	
	/* 도서번호로 도서 조회 */
	BookDTO findOneBookBySequence(int sequence);
	
}
