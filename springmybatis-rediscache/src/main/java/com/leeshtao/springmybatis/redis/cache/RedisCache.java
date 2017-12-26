package com.leeshtao.springmybatis.redis.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisCache implements Cache {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisCache.class);
	
	private static JedisConnectionFactory jedisConnectionFactory;
	
	private String id;
	
	private  final ReadWriteLock  readWriteLock = new ReentrantReadWriteLock();

	public RedisCache(final String id){
		if (id == null) {
			throw new IllegalArgumentException("����ʵ����Ҫһ��Ψһ��ʶ,��:ID");
		}
		LOGGER.debug("���������: id="+id);
		this.id = id;
	}
	
	public void clear() {
		JedisConnection connection = null;
		try
        {
            connection = (JedisConnection) jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }

	}
	
	 public String getId()
	    {
	        return this.id;
	    }

	    public Object getObject(Object key)
	    {
	        Object result = null;
	        JedisConnection connection = null;
	        try
	        {
	            connection = (JedisConnection) jedisConnectionFactory.getConnection();
	            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
	            result = serializer.deserialize(connection.get(serializer.serialize(key)));
	        }
	        catch (JedisConnectionException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return result;
	    }

	    public ReadWriteLock getReadWriteLock()
	    {
	        return this.readWriteLock;
	    }

	    public int getSize()
	    {
	        int result = 0;
	        JedisConnection connection = null;
	        try
	        {
	            connection = (JedisConnection) jedisConnectionFactory.getConnection();
	            result = Integer.valueOf(connection.dbSize().toString());
	        }
	        catch (JedisConnectionException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return result;
	    }

		public void putObject(Object key, Object value)
	    {
	        JedisConnection connection = null;
	        try
	        {
	            connection = (JedisConnection) jedisConnectionFactory.getConnection();
	            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
	            connection.set(serializer.serialize(key), serializer.serialize(value));
	        }
	        catch (JedisConnectionException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }

		public Object removeObject(Object key)
	    {
	        JedisConnection connection = null;
	        Object result = null;
	        try
	        {
	            connection = (JedisConnection) jedisConnectionFactory.getConnection();
	            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
	            result =connection.expire(serializer.serialize(key), 0L);
	        }
	        catch (JedisConnectionException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return result;
	    }

	    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
	        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
	    }

}
