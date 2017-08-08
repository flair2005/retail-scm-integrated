package com.skynet.infrastructure;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PooledRedisCacheService extends RedisCacheService implements CacheService {
	JedisPool pool;
	public PooledRedisCacheService() {
		// TODO Auto-generated constructor stub
		
	}

	public void ensurePool(){
		if(pool != null){
			return;
		}
		pool = new JedisPool(new JedisPoolConfig(), "localhost");
	
	}
	
	protected Jedis getJedis(){	
		
		
		ensurePool();
		return pool.getResource();
	}
	


}
