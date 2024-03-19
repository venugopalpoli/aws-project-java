package com.pts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class PTSMemoryDBConfig {

    @Bean
    public JedisCluster getJedisCluster() throws IOException {
        System.out.println("Reading config file...");

        /** The Amazon MemoryDB for Redis cluster host name. */
        String hostName = "clustercfg.venu-cluster.gcvgb5.memorydb.eu-west-2.amazonaws.com";
        /** The Amazon MemoryDB for Redis cluster port. */
        int port = 6379;

        /**
         * The username to connect to the Amazon MemoryDB for Redis cluster. This should
         * be configured in the cluster's Access Control List (ACL). This username
         * should be given access to the required keys and commands in order to perform
         * the operations in this demo. This is specified in the access string when
         * setting up this username in the ACL.
         */
        String userName = "poi-user";
        /**
         * The password corresponding to the username to connect to the Amazon MemoryDB for
         * Redis cluster. This is configured when setting up this username in the ACL.
         */
        String password = "poi-userpoi-user";

        /** The name that identifies this specific instance of the Jedis client. */
        String clientName = "";

        /** The client timeout value (in seconds). */
        int clientTimeoutInSecs = 20;
        /** The connection timeout value (in seconds). */
        int connectionTimeoutInSecs = 30;
        /** The blocking socket timeout value (in seconds). */
        int blockingSocketTimeoutInSecs = 0;
        /** The socket timeout value (in seconds). */
        int socketTimeoutInSecs = 60;
        /** The maximum retry attempts in case of errors. */
        int maxAttempts = 2;

        /** The flag that specifies if SSL should be used in the connection. */
        Boolean useSSL = Boolean.TRUE;

        System.out.println("Initializing Jedis client for Amazon MemoryDB for Redis...");
        JedisClientConfig jedisClientConfig = DefaultJedisClientConfig.builder().clientName(clientName)
                .timeoutMillis(clientTimeoutInSecs * 1000).connectionTimeoutMillis(connectionTimeoutInSecs * 1000)
                .blockingSocketTimeoutMillis(blockingSocketTimeoutInSecs * 1000)
                .socketTimeoutMillis(socketTimeoutInSecs * 1000).ssl(useSSL).user(userName).password(password).build();
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(new HostAndPort(hostName, port));
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, jedisClientConfig, maxAttempts);
        System.out.println("Completed initializing Jedis client for Amazon MemoryDB for Redis.");

        return jedisCluster;
    }
}
