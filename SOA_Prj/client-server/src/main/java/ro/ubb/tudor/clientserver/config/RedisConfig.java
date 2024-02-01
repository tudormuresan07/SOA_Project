package ro.ubb.tudor.clientserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	@Value("${redis.host}")
	private String redisHost;

	@Value("${redis.port}")
	private int redisPort;

	@Value("${redis.username}")
	private String redisUsername;

	@Value("${redis.password}")
	private String redisPassword;

	@Bean
	@Primary
	public JedisPool jedisPool() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(10);

		return new JedisPool(poolConfig, redisHost, redisPort, 2000, redisPassword);
	}

	@Bean
	public Jedis jedis() {
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPassword);
		return jedis;
	}
}