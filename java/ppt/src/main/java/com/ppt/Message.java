package com.ppt;

import redis.clients.jedis.Jedis;

/**
 * @author Cunlu Wamg
 */
public class Message {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("redis_password");
        jedis.eval("LPUSH string 3");
    }
    synchronized public static void hello() {

    }
}
