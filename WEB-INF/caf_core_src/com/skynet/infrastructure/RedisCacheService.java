package com.skynet.infrastructure;

import redis.clients.jedis.Jedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisCacheService implements CacheService {

	public RedisCacheService() {
		// TODO Auto-generated constructor stub
	}

	protected Jedis getJedis() {

		return new Jedis("localhost");

	}

	ObjectMapper mapper;

	protected ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

	public Object get(String key, Class<?> clazz) {
		// Ticker ticker = new Ticker();
		Jedis jedis = getJedis();
		// ticker.tick("init getJedis();");
		String value = jedis.get(key);
		if (value == null) {
			return null;
		}
		// ticker.tick("jedis.get(key);");
		ObjectMapper mapper = getMapper();
		// ticker.tick(" new ObjectMapper();");
		try {
			Object object = mapper.readValue(value, clazz);
			// ticker.tick(" mapper.readValue(value,clazz);");
			return object;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			jedis.close();
		}

	}

	public void put(String key, Object value, int ttlInSeconds) {
		// Silly impl just for POC
		// Jedis jedis = new Jedis("localhost");
		// Ticker ticker = new Ticker();
		Jedis jedis = getJedis();
		// ticker.tick("init getJedis();");
		ObjectMapper mapper = getMapper();
		// ticker.tick(" new ObjectMapper();");
		try {
			String json = mapper.writeValueAsString(value);
			// ticker.tick("mapper.writeValueAsString(value)");
			jedis.set(key, json);

			jedis.expire(key, ttlInSeconds);
			// ticker.tick("jedis.set(key, json);jedis.expire(key, ttlInSeconds);");

		} catch (JsonProcessingException e) {
			// is fine
		} finally {
			jedis.close();
		}

	}

	public void remove(String key) {
		
		Jedis jedis = getJedis();
		try {
			jedis.del(key);
		} finally {
			jedis.close();
		}
	}

}
/*
 * 
 * ObjectMapper mapper = new ObjectMapper(); // Type t=new
 * TypeToken<weather.WeatherResponse>().getType();
 * //response.getWriter().println(gson.toJson(result.getActualResult()));
 * //mapper /* Order
 * order=(Order)OrdreJsonTool.prepareForJson((Order)result.getActualResult());
 * 
 * 
 * String json = mapper.writeValueAsString(result.getActualResult());
 * 
 * import redis.clients.jedis.Jedis; public class TestJedis {
 * 
 * public static void main(String[] args) throws InterruptedException { String
 * cacheKey = "cachekey"; Jedis jedis = new Jedis("localhost"); //adding a new
 * key jedis.set(cacheKey, "cached value"); //setting the TTL in seconds
 * jedis.expire(cacheKey, 15); //Getting the remaining ttl
 * System.out.println("TTL:" + jedis.ttl(cacheKey)); Thread.sleep(1000);
 * System.out.println("TTL:" + jedis.ttl(cacheKey)); //Getting the cache value
 * System.out.println("Cached Value:" + jedis.get(cacheKey));
 * 
 * //Wait for the TTL finishs Thread.sleep(15000);
 * 
 * //trying to get the expired key System.out.println("Expired Key:" +
 * jedis.get(cacheKey)); }
 * 
 * }
 */