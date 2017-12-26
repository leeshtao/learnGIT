package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leeshtao.cloudnote.share.entity.Share;
import com.leeshtao.cloudnote.share.handler.ShareService;

import util.Object2JSON;

public class TestShareService extends TestBase{
	private ShareService shareService;
	@Before
	public void init(){
		shareService=super.getContext().getBean("shareService", ShareService.class);
	}
	@Test
	public void testSearchNote(){
		String keyword="1";
		List<Share> list=shareService.searchShareNote(keyword,1);
		for(Share s:list){
			System.out.println(Object2JSON.object2JSON(s));
		}
	}
	
	@Test
	public void testSaveShareNote(){
		shareService.saveShareNote(7l);
	}
}






