package com.pts.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PTSMemoryDBServiceTest {

    @Autowired
    private PTSMemoryDBService ptsMemoryDBService;

    @Test
    public void test1()throws Exception{
        // Sample data
        String record1Key = "customer:111";
        String record1Value = "{\"name\":{\"first\": \"First1\", \"last\": \"Last1\"}, \"address\": \"111 Test Street, Test City, Test State, Test Country\", \"phone\": \"+1 111-111-1111\", \"email\": \"first1last1@test.com\"}";
        String record2Key = "customer:222";
        String record2Value = "{\"name\":{\"first\": \"First2\", \"last\": \"Last2\"}, \"address\": \"222 Test Street, Test City, Test State, Test Country\", \"phone\": \"+1 222-222-2222\", \"email\": \"first2last2@test.com\"}";
        String record3Key = "customer:333";
        String record3Value = "{\"first_name\": \"First3\", \"last_name\": \"Last3\", \"address\": \"333 Test Street, Test City, Test State, Test Country\", \"phone\": \"+1 333-333-3333\", \"email\": \"first3last3@test.com\"}";
        String record4Key = "customer:444";

        System.out.println(ptsMemoryDBService.upsertJSONRecord(record1Key, record1Value));
        System.out.println(ptsMemoryDBService.upsertJSONRecord(record2Key, record2Value));
        // Retrieve from JSON records
        System.out.println("Value = " + ptsMemoryDBService.getJSONRecord(record1Key, null));
        System.out.println("Value = " + ptsMemoryDBService.getJSONRecord(record1Key, ".name.first"));
        System.out.println("Value = " + ptsMemoryDBService.getJSONRecord(record1Key, ".address"));

        // Hash record operations:
        // Upsert Hash records
        System.out.println(ptsMemoryDBService.upsertHashRecord(record3Key, record3Value));
        // Retrieve from Hash records
        System.out.println("Value = " + ptsMemoryDBService.getHashRecord(record3Key, null));
        System.out.println("Value = " + ptsMemoryDBService.getHashRecord(record3Key, "first_name"));
        System.out.println("Value = " + ptsMemoryDBService.getHashRecord(record3Key, "address"));

        // Delete operations:
        // Delete an existing record
        System.out.println(ptsMemoryDBService.deleteRecord(record1Key));
        // Try retrieving a deleted record
        System.out.println("Value = " + ptsMemoryDBService.getRecord(record1Key));
        // Try deleting a non-existent record
        System.out.println(ptsMemoryDBService.deleteRecord(record4Key));

    }
}
