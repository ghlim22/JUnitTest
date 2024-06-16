import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {
    private BookManager bm;
    private long startTime;
    private static final long TEST_SIZE = 10000;
    
    @BeforeAll
    public static void printInfo() {
    	System.out.println("Test size: " + TEST_SIZE);
    }

    @BeforeEach
    public void setUp() {
        bm = new BookManager();
        for (int i = 0; i < TEST_SIZE; ++i) {
        	bm.addBook(i, "Java Programming", "Soyoon Paek", 2020);
    	}
        //startTime = System.currentTimeMillis();
    }
    
    @AfterEach
    public void measurePerformance() {
//    	long endTime = System.currentTimeMillis();
//    	long msElapsed = endTime - startTime;
//    	System.out.println("elapsed time(ms): " + msElapsed);
    }
    
    @Test
    public void testSearchBookPerformance() {
    	System.out.println("Linear Search");
    	final long start = System.currentTimeMillis();
    	for (int i = 0; i < TEST_SIZE; ++i) {
    	    bm.searchBook(i);
    	}
    	final long end = System.currentTimeMillis();
    	long msElapsed = end - start;
    	System.out.println("elapsed time(ms): " + msElapsed);
    	
    }
    
    @Test
    public void testSearchBsPerformance() {
    	System.out.println("Binary Search");
    	final long start = System.currentTimeMillis();
    	for (int i = 0; i < TEST_SIZE; ++i) {
    	    bm.search_bs(i);
    	}
    	final long end = System.currentTimeMillis();
    	final long msElapsed = end - start;
    	System.out.println("elapsed time(ms): " + msElapsed);
    }
}

