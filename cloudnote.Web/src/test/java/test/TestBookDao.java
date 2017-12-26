package test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leeshtao.cloudnote.book.dao.BookDao;
import com.leeshtao.cloudnote.book.entity.Book;

public class TestBookDao extends TestBase {
	private BookDao bookDao;
	@Before
	public void init(){
		bookDao=super.getContext().getBean(
				"bookDao", BookDao.class);
	}
	//@Test
	public void test(){
		List<Book> list
			=bookDao.findByUserId(1l);
		for(Book book:list){
			System.out.println(book);
		}
	}
	@Test
	public void testSave(){
		Book book=new Book();
		book.setCnUserId(1000000000012l);
		book.setCnNoteBookName("cloudnote");
		book.setCnNoteBookTypeId(5l);
		bookDao.save(book);
	}
}







