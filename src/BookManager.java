import java.util.HashMap;

public class BookManager {
	public class Book {
		public Book(int id, String title, String author, int year) {
			mID = id;
			mTitle = title;
			mAuthor = author;
			mYear = year;
		} 
		int mID;
		String mTitle;
		String mAuthor;
		int mYear;
	}
	
	HashMap<Integer, Book> mBooks;
	
	public BookManager()
	{
		mBooks = new HashMap<>();
	}
	public int AddBook(int id, String title, String author, int year) {
		if (mBooks.containsKey(id)) {
			System.out.println("해당 id (" + id + ")는 이미 존재합니다.");
			return 0;
		}
		Book b = new Book(id, title, author, year);
		mBooks.put(id, b);
		System.out.println("Book { id: " + b.mID + ", title: " + b.mTitle + ", author: " + b.mAuthor + ", printed year: " + b.mYear + "} 도서가 추가되었습니다. ");
		return 1;
	}
	
	public int SearchBook(int id) {
		if (!mBooks.containsKey(id)) {
			System.out.println("검색된 도서가 없습니다.");
			return 0;
		}
	    Book b = mBooks.get(id);
	    
	    System.out.println("검색 결과: ");
	    System.out.println("Book{ id: " + b.mID + ", title: " + b.mTitle + ", author: " + b.mAuthor + ", printed year: " + b.mYear + "}");
	    return 1;
	 
	}
	
	public int RemoveBook(int id) {
		if (!mBooks.containsKey(id)) {
			System.out.println("해당 도서가 없습니다.");
			return 0;
		}
		Book b = mBooks.get(id);
		System.out.println("Book{ id: " + b.mID + ", title: " + b.mTitle + ", author: " + b.mAuthor + ", printed year: " + b.mYear + "} 도서를 삭제하였습니다. ");
	    mBooks.remove(id);
	    return 1;
	}
}
