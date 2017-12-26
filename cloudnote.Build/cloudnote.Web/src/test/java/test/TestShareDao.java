package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.leeshtao.cloudnote.note.dao.NoteDao;
import com.leeshtao.cloudnote.share.dao.ShareDao;
import com.leeshtao.cloudnote.share.entity.Share;

public class TestShareDao extends TestBase{
	private NoteDao noteDao;
	private ShareDao shareDao;
	@Before
	public void init(){
		shareDao=super.getContext().getBean(
				"shareDao", ShareDao.class);
		noteDao=super.getContext().getBean(
				"noteDao", NoteDao.class);
	}
	//@Test
	public void testSave(){
		Share share=new Share();
		share.setCnShareTitle("TESTSHARE");
		share.setCnShareBody("share...");
		share.setCnNoteId(1l);
		
		shareDao.save(share);
	}
	@Test
	public void testFindByTitle(){
		String title="测试笔记——1";
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		List<Share> list=shareDao.findLikeTitle(map);
		for(Share s:list){
			System.out.println(
						s.getCnNoteId()
						+","+ s.getCnShareTitle());
		}
	}
}









