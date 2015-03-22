package com.webapp.dao.impl.mdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;

import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.io.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.House;
import com.webapp.model.User;

import java.util.List;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserMultiThreadTest extends SpringTransactionContextTest
{
	
	public static final int NUM_THREADS = 1;
	public static int TIMES = 40000;
    public static final int NUM_DOCUMENTS = 10;
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;

	int start;
	int stop;
	
	public void createList()
	{
		for(int i = 0; i < 100; i++)
		{
			User u = new User();
			userDao.save(u);
		}
	}
	
	public void findByString()
	{
		for(int i = 0; i < TIMES; i++)
		{
			List<User> result = userDao.findAll("{ studentId : {$in :[12, 13]}}");
			assertEquals( result.size(),2 );
		}
	}
	
	public void single()
	{
		findByString();
	}


	//@Test
    public static void main(String[] args) throws UnknownHostException 
    {
    	
        MongoClientURI uri = args.length > 0
                             ? new MongoClientURI(args[0])
                             : new MongoClientURI("mongodb://localhost");
        MongoClient mongoClient = new MongoClient(uri);

        DB db = mongoClient.getDB(uri.getDatabase() != null
                                  ? uri.getDatabase()
                                  : "test");

        final DBCollection collection = db.getCollection("test");
        collection.drop();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        
        
//        startTime=System.currentTimeMillis();
//        
//        for(int i = 0; i < TIMES; i++)
//        {
//        	findByString();
//        }
//        
//        totalTime=System.currentTimeMillis()-startTime;
//        System.out.println("single: "+totalTime+" ms");
        

        //startTime=System.currentTimeMillis();
        
        for (int i = 0; i < NUM_THREADS; i++) 
        {
            executorService.submit(new Runnable() 
            {
                @Override
                public void run() 
                {    
                	long startTime,totalTime;
                    Random random = new Random();
                    
                    startTime=System.currentTimeMillis();
                                     
                    for(int j = 0; j < (TIMES / NUM_THREADS); j++)
                    {
                    	int i = random.nextInt(NUM_DOCUMENTS);
                    	
                        try {
                            DBObject document = collection.find(new BasicDBObject("i", i))
                                                          .setReadPreference(ReadPreference.secondaryPreferred())
                                                          .one();
                            if (document == null) {
                                collection.insert(new BasicDBObject("i", i));
                            } 
                            else {
                                collection.update(new BasicDBObject("_id", document.get("_id")),
                                                  new BasicDBObject("$set", new BasicDBObject("i", i + 1)));
                            }
                        } 
                        catch (Exception e) {
                            e.printStackTrace();
                        }  
                        
                    }
                    totalTime=System.currentTimeMillis()-startTime;
                    System.out.println("multi: "+totalTime+" ms");
                    
                }
            });
        }
        
        
        
    }

}
