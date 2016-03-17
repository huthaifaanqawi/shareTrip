package edu.mum.shareTrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	@Query("select b from BOOK b where b.member.id =:id")
	public List<Book> getAllBooksByMemberId(@Param("id")long id);
}
