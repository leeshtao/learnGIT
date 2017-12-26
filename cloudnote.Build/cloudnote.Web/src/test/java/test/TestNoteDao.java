package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leeshtao.cloudnote.common.exception.NoteBookNotFoundException;
import com.leeshtao.cloudnote.note.dao.NoteDao;
import com.leeshtao.cloudnote.note.entity.Note;

import util.Object2JSON;

public class TestNoteDao extends TestBase{
	private static Logger logger = LoggerFactory.getLogger(TestNoteDao.class);
	private NoteDao noteDao;
	@Before
	public void init(){
	noteDao
	=super.getContext().getBean(
			"noteDao", NoteDao.class);
	}
	@Test
	public void test(){
		List<Note> list=noteDao.findByBookId(21l);
		if (!list.isEmpty()) {
			for(Note note:list){
				System.out.println(Object2JSON.object2JSON(note));
			}
		}else {
			logger.error("笔记不存在");
			throw new NoteBookNotFoundException("笔记不存在");
		}
		
	}
	@Test
	public void testFindNotes(){
		Map params=new HashMap();
		params.put("userId",100000000001L);
		//params.put("title", "大方地爱上撒旦发斯蒂芬");
		List<Note> list=noteDao.findNotes(params);
		if (!list.isEmpty()) {
			for(Note note:list){
				System.out.println(Object2JSON.object2JSON(note));
			}
		}else {
			logger.error("没有找到笔记");
			return;
		}
		
	}
}














