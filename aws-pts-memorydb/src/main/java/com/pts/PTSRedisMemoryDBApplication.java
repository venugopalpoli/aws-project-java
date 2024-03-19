/* 
 * 
 * Copyright 2022 Amazon.com, Inc. or its affiliates.  All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 * 
 */
package com.pts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PTSRedisMemoryDBApplication {


	/**
	 * The main method performs the following,
	 * 
	 * <pre>
	 * 1. Reads the config file.
	 * 2. Instantiates the Jedis client to connect to the Amazon MemoryDB for Redis cluster.
	 * 3. Upsert operations.
	 * 4. Retrieve operations.
	 * 5. Delete operations.
	 * 6. Shuts down this demo program.
	 * </pre>
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		SpringApplication.run(PTSRedisMemoryDBApplication.class, args);

	}



}
