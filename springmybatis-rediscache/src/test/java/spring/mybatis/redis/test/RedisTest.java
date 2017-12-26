package spring.mybatis.redis.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

import redis.clients.jedis.Jedis;

public class RedisTest {

	private Jedis jedis;
	@Before
	public void init(){
		//���ӱ��ص� Redis ����
	    jedis = new Jedis("127.0.0.1");
	    System.out.println("���ӳɹ�");
	}
	@Test
	public void connectionTest() {
	      //�鿴�����Ƿ�����
	      System.out.println("��������������: "+jedis.ping());
	}
	
	@Test
	public void redisStringTest(){
	      //���� redis �ַ�������
	      jedis.set("w3ckey", "www.w3cschool.cn");
	     // ��ȡ�洢�����ݲ����
	     System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("w3ckey"));
	}
	
	@Test
	public void redisListTest(){
	      //�洢���ݵ��б���
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // ��ȡ�洢�����ݲ����
	     List<String> list = jedis.lrange("tutorial-list", 0 ,2);
	     for(int i=0; i<list.size(); i++) {        
	       System.out.println("�б���Ϊ: "+list.get(i));      
	     }  
	}
	
	@Test
	public void redisKeyTest(){
		// ��ȡ���ݲ����
	     Set<String> keys= jedis.keys("*");
	     Iterator<String> it=keys.iterator();
	     while(it.hasNext()) {   
	       String key=it.next();     
	       System.out.println(key);     
	     }    
	}
}

