import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	
	BookManager m;
	
	@BeforeEach
	void setUp() throws Exception {
		m = new BookManager();
	}

	@Test
	void testAddBook() {
		assertEquals(1, m.AddBook(1, "자바 기초", "Jane", 2021), "add failed");
		assertEquals(0, m.AddBook(1, "자바 기초", "Jane", 2021), "duplicated");
		assertEquals(1, m.AddBook(2, "C 언어 기초", "Kim", 1993), "add failed");
		assertEquals(0, m.AddBook(2, "C 언어 기초", "Kim", 1993), "add failed");
		assertEquals(1, m.AddBook(3, "디자인 패턴" , "Park", 2020), "add failed");
		assertEquals(0, m.AddBook(3, "디자인 패턴" , "Park", 2020), "duplicated");
		assertEquals(1, m.SearchBook(1), "add failed");
		assertEquals(0, m.SearchBook(5), "add failed");
	}

	@Test
	void testSearchBook() {
		m.AddBook(1, "자바 기초", "jane", 2022);
		m.AddBook(2, "자바 심화", "jane", 2023);
		m.AddBook(3, "C 언어 기초", "Kim", 1993);
		m.AddBook(4, "디자인 패턴" , "Park", 2020);
		assertEquals(1, m.SearchBook(1), "search failed");
		assertEquals(1, m.SearchBook(2), "search failed");
		assertEquals(1, m.SearchBook(3), "search failed");
		assertEquals(1, m.SearchBook(4), "search failed");
		assertEquals(0, m.SearchBook(5), "search failed");
		
	}

	@Test
	void testRemoveBook() {
		m.AddBook(1, "자바 기초", "jane", 2022);
		m.AddBook(2, "자바 심화", "jane", 2023);
		m.AddBook(3, "C 언어 기초", "Kim", 1993);
		m.AddBook(4, "디자인 패턴" , "Park", 2020);
		assertEquals(1, m.RemoveBook(1), "remove failed");
		assertEquals(1, m.RemoveBook(2), "remove failed");
		assertEquals(1, m.RemoveBook(3), "remove failed");
		assertEquals(1, m.RemoveBook(4), "remove failed");
		assertEquals(0, m.SearchBook(1), "remove failed");
		assertEquals(0, m.SearchBook(2), "remove failed");
		assertEquals(0, m.SearchBook(3), "remove failed");
		assertEquals(0, m.SearchBook(4), "remove failed");
	}
	
		

}
