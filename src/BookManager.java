import java.util.LinkedList;
import java.util.ListIterator;

public class BookManager {
    private class Book {
        int mID;
        String mTitle;
        String mAuthor;
        int mYear;

        public Book(int id, String title, String author, int year) {
            mID = id;
            mTitle = title;
            mAuthor = author;
            mYear = year;
        }

        @Override
        public String toString() {
            return "Book { id: " + mID + ", title: " + mTitle + ", author: " + mAuthor + ", printed year: " + mYear + " }";
        }
    }

    private LinkedList<Book> mBookList;

    public BookManager() {
        mBookList = new LinkedList<>();
    }

    public void addBook(int id, String title, String author, int year) {
        Book newBook = new Book(id, title, author, year);
        
        ListIterator<Book> iterator = mBookList.listIterator();
        while (iterator.hasNext()) {
            Book currentBook = iterator.next();
            if (currentBook.mID == id) {
                System.out.println("The book with id (" + id + ") already exists.");
                return;
            } else if (currentBook.mID > id) {
                iterator.previous();  // Step back to the correct insertion point
                iterator.add(newBook);
                System.out.println(newBook + " has been added.");
                return;
            }
        }
        
        // The new book has the highest ID
        mBookList.add(newBook);
        System.out.println(newBook + " has been added.");
    }

    public void searchBook(int id) {
        for (Book b : mBookList) {
            if (b.mID == id) {
                System.out.println("Search result: " + b);
                return;
            }
        }
        System.out.println("No book found with the given id.");
    }

    public void removeBook(int id) {
        ListIterator<Book> iterator = mBookList.listIterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.mID == id) {
                iterator.remove();
                System.out.println(b + " has been removed.");
                return;
            }
        }
        System.out.println("No book found with the given id.");
    }
    
    public void search_bs(int id) {
        int index = binarySearch(id);
        if (index != -1) {
            System.out.println("Search result: " + mBookList.get(index));
        } else {
            System.out.println("No book found with the given id.");
        }
    }

    private int binarySearch(int id) {
        int left = 0;
        int right = mBookList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = mBookList.get(mid);
            
            if (midBook.mID == id) {
                return mid;
            } else if (midBook.mID < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;  // ID not found
    }

    public static void main(String[] args) {
        BookManager bm = new BookManager();
        bm.addBook(1, "Java Programming", "Soyoon Paek", 2020);
        bm.addBook(3, "Python Programming", "Minsoo Park", 2021);
        bm.addBook(2, "C++ Programming", "Jinsoo Kim", 2019);

        bm.searchBook(1);
        bm.searchBook(3);
        bm.searchBook(4);

        bm.removeBook(2);
        bm.removeBook(3);
    }
}
