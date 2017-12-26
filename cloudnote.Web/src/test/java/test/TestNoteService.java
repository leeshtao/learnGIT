package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leeshtao.cloudnote.note.entity.Note;
import com.leeshtao.cloudnote.note.handler.NoteService;

import util.Object2JSON;


public class TestNoteService extends TestBase{
	private static Logger logger = LoggerFactory.getLogger(TestNoteService.class);
	private NoteService noteService;
	@Before
	public void init(){
		noteService=super.getContext().getBean(
				"noteService", NoteService.class);
	}
	@Test
	public void test(){
		
		List<Note> list=noteService.listNotes(22l);
		if (!list.isEmpty()) {
			for(Note note:list){
				System.out.println(Object2JSON.object2JSON(note));
			}
		}else {
			logger.error("没有找到相关笔记");
			return;
		}
		
	}
	@Test
	public void testDelNotes(){
		noteService.delNotes(4l,5l,3l);			
	}
	
	@Test
	public void testAddNote(){
		Note note= noteService.addNote(100000000012l, 23l, "Maven部署测试");
		System.out.println(Object2JSON.object2JSON(note));
	}
	
	@Test
	public void testDelNote(){
		noteService.delNote(6l);
	}
}







