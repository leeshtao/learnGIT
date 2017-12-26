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
		//连接本地的 Redis 服务
	    jedis = new Jedis("127.0.0.1");
	    System.out.println("连接成功");
	}
	@Test
	public void connectionTest() {
	      //查看服务是否运行
	      System.out.println("服务器正在运行: "+jedis.ping());
	}
	
	@Test
	public void redisStringTest(){
	      //设置 redis 字符串数据
	      jedis.set("w3ckey", "www.w3cschool.cn");
	     // 获取存储的数据并输出
	     System.out.println("redis 存储的字符串为: "+ jedis.get("w3ckey"));
	}
	
	@Test
	public void redisListTest(){
	      //存储数据到列表中
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // 获取存储的数据并输出
	     List<String> list = jedis.lrange("tutorial-list", 0 ,2);
	     for(int i=0; i<list.size(); i++) {        
	       System.out.println("列表项为: "+list.get(i));      
	     }  
	}
	
	@Test
	public void redisKeyTest(){
		// 获取数据并输出
	     Set<String> keys= jedis.keys("*");
	     Iterator<String> it=keys.iterator();
	     while(it.hasNext()) {   
	       String key=it.next();     
	       System.out.println(key);     
	     }    
	}
}

