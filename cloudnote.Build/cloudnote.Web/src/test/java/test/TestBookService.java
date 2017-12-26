package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leeshtao.cloudnote.book.entity.Book;
import com.leeshtao.cloudnote.book.handler.BookService;

import util.Object2JSON;

public class TestBookService 
					extends TestBase{
	private BookService bookService;
	@Before
	public void init(){
		bookService=super.getContext().getBean(
				"bookService", BookService.class);
	}
	@Test
	public void test(){
		List<Book> list=bookService.listBooks(100000000003L);
		System.out.println("ID"+"\tBookName");
		for(Book book:list){
			System.out.println(book.getId()+"\t"+book.getCnNoteBookName());
		}
	}
	@Test
	public void testAddBook(){
		Book book=bookService.addBook(100000000001L, "JavaSource");
		System.out.println(Object2JSON.object2JSON(book));
	}
}










