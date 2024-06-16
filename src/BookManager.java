import java.util.Arrays;

public class BookManager {
    public class Book implements Comparable<Book> {
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

        @Override
        public int compareTo(Book other) {
            return Integer.compare(this.mID, other.mID);
        }
    }

    private Book[] mBookArray;
    private int size;

    public BookManager() {
        mBookArray = new Book[10];
        size = 0;
    }

    public void addBook(int id, String title, String author, int year) {
        if (size == mBookArray.length) {
            mBookArray = Arrays.copyOf(mBookArray, mBookArray.length * 2);
        }
        
        Book newBook = new Book(id, title, author, year);

        int insertIndex = Arrays.binarySearch(mBookArray, 0, size, newBook);
        if (insertIndex >= 0) {
            System.out.println("The book with id (" + id + ") already exists.");
            return;
        }
        
        insertIndex = -insertIndex - 1;

        System.arraycopy(mBookArray, insertIndex, mBookArray, insertIndex + 1, size - insertIndex);
        mBookArray[insertIndex] = newBook;
        size++;
        System.out.println(newBook + " has been added.");
    }

    public void searchBook(int id) {
        int index = binarySearch(id);
        if (index >= 0) {
            System.out.println("Search result: " + mBookArray[index]);
        } else {
            System.out.println("No book found with the given id.");
        }
    }

    private int binarySearch(int id) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mBookArray[mid].mID == id) {
                return mid;
            } else if (mBookArray[mid].mID < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;  // ID not found
    }

    public void removeBook(int id) {
        int index = binarySearch(id);
        if (index >= 0) {
            Book removedBook = mBookArray[index];
            System.arraycopy(mBookArray, index + 1, mBookArray, index, size - index - 1);
            size--;
            mBookArray[size] = null;  // Clear reference for garbage collection
            System.out.println(removedBook + " has been removed.");
        } else {
            System.out.println("No book found with the given id.");
        }
    }

    public static void main(String[] args) {
        BookManager bm = new BookManager();
        bm.addBook(1, "Java Programming", "John Doe", 2020);
        bm.addBook(3, "Python Programming", "Jane Doe", 2021);
        bm.addBook(2, "C++ Programming", "Jim Beam", 2019);

        bm.searchBook(1);
        bm.searchBook(3);
        bm.searchBook(4);

        bm.removeBook(2);
        bm.removeBook(3);
    }
}

