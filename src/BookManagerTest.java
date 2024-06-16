import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {
    private BookManager bm;

    @BeforeEach
    public void setUp() {
        bm = new BookManager();
        bm.addBook(1, "Java Programming", "Soyoon Paek", 2020);
        bm.addBook(2, "Python Programming", "Minsoo Park", 2021);
        bm.addBook(3, "C++ Programming", "Jinsoo Kim", 2019);
        bm.addBook(4, "SW Engineering", "Eunman Choi", 2019);
        bm.addBook(5, "The C Programming Language", "Brian W. Kernighan & Dennis M. Ritchie", 2019);
        bm.addBook(6, "Think, Fast and Slow", "Daniel Kahneman", 2019);
        bm.addBook(7, "Nudge", " Richard H. Thaler & Cass R. Sunstein", 2019);
        bm.addBook(8, "Book8", "Kim8", 2019);
        bm.addBook(9, "Book9", "Kim9", 2019);
        bm.addBook(10, "Book10", "Kim10", 2019);
        bm.addBook(11, "Book10", "Kim10", 2019);
        bm.addBook(12, "Book10", "Kim10", 2019);
    }

    @Test
    public void testSearchBookPerformance() {
        int searchId = 2;
        bm.searchBook(searchId);
    }
    
    @Test
    public void testSearchBsPerformance() {
    	int searchId = 2;
        bm.search_bs(searchId);
    }
}

