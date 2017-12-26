package json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class JsonTest {
	/*
	 * 将java对象转换成json字符串
	 * 
	 */
	public static void test1() throws JsonProcessingException {
		Stock s = new Stock();
		s.setCode("600877");
		s.setName("中国嘉陵");
		s.setPrice(10.0);
		//使用json提供的工具来转换
		ObjectMapper om = new ObjectMapper();
		String jString = om.writeValueAsString(s);
		System.out.println(jString);
	}
	
	public static void test2() throws JsonProcessingException {
		List<Stock> stocks = new ArrayList<Stock>();
		for(int i=0; i<3; i++) {
			Stock s = new Stock();
			s.setCode("600877"+i);
			s.setName("中国嘉陵"+i);
			s.setPrice(10.0+i);
			stocks.add(s);
		}
		ObjectMapper om = new ObjectMapper();
		String jString = om.writeValueAsString(stocks);
		System.out.println(jString);
		
	}
	public static void main(String[] args) throws JsonProcessingException {
		test2();
	}
}
