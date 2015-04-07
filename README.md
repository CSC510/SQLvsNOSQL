# SQLvsNOSQL
Comparison between Oracle and MongoDB

##Background

##Goals

##Differences between SQL and NoSQL

###


###


##Testing System Design

###MVC FrameWork

###Testing Methods

##Testing Result

####Single Thread Add Performance Comparison
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
<th align="left">1000</th>
<th align="left">5000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">140000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">MongoDB</td>
<td align="left">1411</td>
<td align="left">2263</td>
<td align="left">2641</td>
<td align="left">2668</td>
<td align="left">5352</td>
<td align="left">8600</td>
<td align="left">13137</td>
<td align="left">17449</td>
<td align="left">21908</td>
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
</tbody>
</table>

####Single Thread Find Performance Comparison I
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
<th align="left">1000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">140000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">MongoDB</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
</tbody>
</table>

####Single Thread Find Performance Comparison II
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
<th align="left">1000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">140000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">MongoDB</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
</tbody>
</table>

####Single Thread Delete Performance Comparison I
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
<th align="left">1000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">140000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">MongoDB</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
<td align="left"></td>
</tr>
</tbody>
</table>


###More in NoSQL DB (Multi-Thread Test)

In order to test the multi-thread performance of NoSQL databases, we have picked the Mongo Database and tested its insert, findbyId, delete performance by comparing its time cost in different threads. We have used single thread, dual threads, four threads and eight threads to execute query so that we could see whether using <b>multiple threads</b> is an effective way to <b>save time</b> in Mongo like NOSQL databases.

####Multi-Thread Add Performance
To test the insert performance, we have utilized the control variates method by using different number of threads to add the same number of records to the database. And after that we increase the records inserted to the database and check the time for inserting to see if there is any difference using different number of threads.

#####Data

<table>
<thead>
<tr class="header">
<th align="left">#Threads/Data Inserted</th>
<th align="left">1000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">100000</th>
<th align="left">140000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">1 Thread</td>
<td align="left">1228</td>
<td align="left">5493</td>
<td align="left">7793</td>
<td align="left">10214</td>
<td align="left">18614</td>
<td align="left">21057</td>
<td align="left">24557</td>
<td align="left">23865</td>
<td align="left">33061</td>
</tr>
<tr class="even">
<td align="left">2 Threads</td>
<td align="left">1175</td>
<td align="left">4707</td>
<td align="left">6859</td>
<td align="left">8906</td>
<td align="left">15489</td>
<td align="left">15341</td>
<td align="left">18995</td>
<td align="left">23215</td>
<td align="left">28381</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">1188</td>
<td align="left">5346</td>
<td align="left">8120</td>
<td align="left">12122</td>
<td align="left">17250</td>
<td align="left">18727</td>
<td align="left">22316</td>
<td align="left">26486</td>
<td align="left">29256</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">1138</td>
<td align="left">6076</td>
<td align="left">10204</td>
<td align="left">13968</td>
<td align="left">18527</td>
<td align="left">22397</td>
<td align="left">24609</td>
<td align="left">29854</td>
<td align="left">32018</td>
</tr>
</tbody>
</table>

We have tested 9 groups of data, each column of the first row means the number of data that have been inserted into the database, from 1000 to 200000. And the corresponding column on the second to the fifth row is the number of time in millisecond that is spent on this insertion. For two or more threads, the time given is the last-finished time the threads take to perform the insertion. 

For example, if the insert 1000 records of data using 4 threads, each of the threads will only insert 250 items of data, each taking 1020 ms, 1100 ms, 869 ms, 1188 ms. Therefore, the total amount of time showed on the table would the max of the four time which is 1188 ms. The insertion can not be defined as finished until the last thread finishes its job.

#####Figure
<img src="img/multi_insert.png"/>
#####Analysis

From the figure, we can easily see that the number of threads doesn't have much improvement on the time used to do the insertion. The time line travels across each other at times and increase linearly with the upsuring inserted records. 

The reason why multi-thread has no effect on the insertion performance is probably because of the lock system of the database. When one thread has entered the critical section, other thread has to wait until the ongoing thread finish. In that case, the multiple threads just divide the task separetely and use almost the same amount of time as the single thread does.  Therefore, for insertion, there is no point to use multi-thread to visit the database as multiple threads may consume more resources than single thread.

####Multi-Thread Find Performance

To test the find performance, we have implemented two test methods. Both of the methods have utilized the control variates method. One is to find certain number of records in the database while the number of records in the database is increasing. The other is to find an increasing number of records in a database with fixed number of records. Both of the methods compare the result with single thread and multi-thread. The time is counted to see if multi-thread execution has any benefit on the time factor.

##### Find Performance Test I

In Find Performance test I, the task is to find an increasing number of records in the database with 200000 records. The time of the query is calculated and compared with the result using two or more threads. 

######Data

<table>
<thead>
<tr class="header">
<th align="left">#Threads</th>
<th align="left">1000</th>
<th align="left">5000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">120000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">1 Thread</td>
<td align="left">669</td>
<td align="left">2556</td>
<td align="left">4336</td>
<td align="left">7670</td>
<td align="left">10210</td>
<td align="left">19119</td>
<td align="left">23878</td>
<td align="left">33536</td>
<td align="left">40495</td>
</tr>
<tr class="even">
<td align="left">2 Threads</td>
<td align="left">531</td>
<td align="left">2205</td>
<td align="left">3672</td>
<td align="left">6132</td>
<td align="left">7463</td>
<td align="left">13545</td>
<td align="left">16597</td>
<td align="left">22391</td>
<td align="left">24650</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">592</td>
<td align="left">1863</td>
<td align="left">3291</td>
<td align="left">5376</td>
<td align="left">8999</td>
<td align="left">12298</td>
<td align="left">19754</td>
<td align="left">20307</td>
<td align="left">26495</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">360</td>
<td align="left">1479</td>
<td align="left">2647</td>
<td align="left">5427</td>
<td align="left">7908</td>
<td align="left">13954</td>
<td align="left">18270</td>
<td align="left">19893</td>
<td align="left">26214</td>
</tr>
</tbody>
</table>

We have tested 9 groups of data, each column of the first row means the number of data that needs to be acquired through the query process, from 1000 to 200000. And the corresponding column on the second to the fifth row is the number of time in millisecond that is spent on this query. For two or more threads, the time given is the last-finished time of the threads take to perform the query. 

######Figure

<img src="img/multi_find_1.png"/>
######Analysis

As you can see from the above figure, the time spend on the single thread is larger than multi-thread ones. It almost takes 50% more time than the multi-thread ones, which is 40000 ms compared to 25000 ms. From this prospective, we can infer that using multi-thread will improve the time factor on the query like execution on the Mongo like NoSQL database. However, we could also see that the time spent on query by two or more threads are almost the same, which means the performance gained through adding threads is limited. If you have already got two threads performing the query on the NoSQL databases, adding more threads won't bring you significant improvement as you may expect. 


 - [  ] Reason


##### Find Performance Test II

In Find Performance test II, the task is to find 5000 records in the database while the number of records in the database is increasing, from 10000 to 200000. The time of the query is calculated and compared with the result using two or more threads. 

######Data

<table>
<thead>
<tr class="header">
<th align="left">#Threads</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">1 Thread</td>
<td align="left">3024</td>
<td align="left">4126</td>
<td align="left">2715</td>
<td align="left">2820</td>
<td align="left">3626</td>
<td align="left">3282</td>
</tr>
<tr class="even">
<td align="left">2 Threads</td>
<td align="left">2577</td>
<td align="left">2792</td>
<td align="left">2538</td>
<td align="left">2567</td>
<td align="left">3544</td>
<td align="left">3053</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">2054</td>
<td align="left">2285</td>
<td align="left">2080</td>
<td align="left">2527</td>
<td align="left">2849</td>
<td align="left">2116</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">1788</td>
<td align="left">1630</td>
<td align="left">1889</td>
<td align="left">1755</td>
<td align="left">1916</td>
<td align="left">2265</td>
</tr>
</tbody>
</table>

We have tested 7 groups of data, each column of the first row means the number of records existing in the database, from 10000 to 200000. And the corresponding column on the second to the fifth row is the number of time in millisecond that is spent on finding 5000 records in this database. For two or more threads, the time given is the last-finished time of the threads take to perform the query. 

######Figure
<img src="img/multi_find_2.png"/>

######Analysis

We can infer from the above figure that the time spent on searching won't increase a lot as the amount of records existing in the database increases. The time is around 2000 ms to 4000 ms. Multiple threads do have some impact on the time cost of the query process, but it is not worthwhile. The most significant gap between single and multiple threads is 2000 ms which is 2 seconds. It won't be an issue for using another 2 seconds to find 5000 data in a database in worst-case scenario. However, if the number of records needs to found increases, maybe multi-thread way would be a more acceptable methods.

####Multi-Thread Delete Performance

To test the delete multi-thread performance of NoSQL database, we have implemented two test methods. Both of the methods have utilized the control variates method. One is to delete certain number of records in the database while the number of records in the database is increasing. The other is to delete an increasing number of records in a database with fixed number of records. Both of the methods compare the result with single thread and multi-thread. The time is counted to see if multi-thread execution has any benefit on the time factor.

##### Delete Performance Test I

In Delete Performance test I, the task is to delete an increasing number of records in a database with 200000 records. The time of the deletion is calculated and compared with the result using two or more threads. 

######Data

<table>
<thead>
<tr class="header">
<th align="left">#Threads</th>
<th align="left">1000</th>
<th align="left">5000</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">120000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">1 Thread</td>
<td align="left">202</td>
<td align="left">819</td>
<td align="left">1286</td>
<td align="left">2380</td>
<td align="left">5075</td>
<td align="left">11026</td>
<td align="left">20619</td>
<td align="left">24445</td>
<td align="left">31485</td>
</tr>
<tr class="even">
<td align="left">2 Threads</td>
<td align="left">270</td>
<td align="left">855</td>
<td align="left">1507</td>
<td align="left">2879</td>
<td align="left">3934</td>
<td align="left">5965</td>
<td align="left">18703</td>
<td align="left">25558</td>
<td align="left">29463</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">398</td>
<td align="left">862</td>
<td align="left">1679</td>
<td align="left">2398</td>
<td align="left">5443</td>
<td align="left">10588</td>
<td align="left">21461</td>
<td align="left">29038</td>
<td align="left">34204</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">319</td>
<td align="left">1290</td>
<td align="left">1402</td>
<td align="left">2304</td>
<td align="left">4006</td>
<td align="left">15926</td>
<td align="left">21977</td>
<td align="left">21817</td>
<td align="left">26349</td>
</tr>
</tbody>
</table>

We have tested 9 groups of data, each column of the first row means the number of data that needs to be deleted through the deletion process, from 1000 to 200000. And the corresponding column on the second to the fifth row is the number of time in millisecond that is spent on this query. For two or more threads, the time given is the last-finished time of the threads take to perform the deletion. 

######Figure

<img src="img/multi_del_1.png"/>

######Analysis

As we can infer from the figure, the time spent on the deletion increases with the number of delete operation increase, as we expected. The multiple threads don't help to shorten the time spend on the deletion. This is probably the same reason as in the insertion, the lock in the database prohibit multiple threads entering the critical section of the deletion process. Therefore, only one thread would be able to perform normally and others are set to wait until it finishes.


##### Delete Performance Test II

In Delete Performance test II, the task is to delete an 5000 records in the database while the number of records in the database is increasing, from 10000 to 200000. The time of the deletion is calculated and compared with the result using two or more threads. 

######Data

<table>
<thead>
<tr class="header">
<th align="left">#Threads</th>
<th align="left">10000</th>
<th align="left">20000</th>
<th align="left">40000</th>
<th align="left">80000</th>
<th align="left">120000</th>
<th align="left">160000</th>
<th align="left">200000</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td align="left">1 Thread</td>
<td align="left">1418</td>
<td align="left">1890</td>
<td align="left">1481</td>
<td align="left">1411</td>
<td align="left">1986</td>
<td align="left">1026</td>
<td align="left">936</td>
</tr>
<tr class="even">
<td align="left">2 Threads</td>
<td align="left">1238</td>
<td align="left">1415</td>
<td align="left">1024</td>
<td align="left">1706</td>
<td align="left">1595</td>
<td align="left">934</td>
<td align="left">1055</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">1412</td>
<td align="left">1319</td>
<td align="left">930</td>
<td align="left">1371</td>
<td align="left">1404</td>
<td align="left">919</td>
<td align="left">1053</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">1280</td>
<td align="left">1487</td>
<td align="left">1053</td>
<td align="left">1190</td>
<td align="left">996</td>
<td align="left">1233</td>
<td align="left">1186</td>

</tr>
</tbody>
</table>

We have tested 7 groups of data, each column of the first row means the number of records existing in the database, from 10000 to 200000. And the corresponding column on the second to the fifth row is the number of time in millisecond that is spent on deleting 5000 records in this database. For two or more threads, the time given is the last-finished time of the threads take to perform the query. 

######Figure

<img src="img/multi_del_2.png"/>

######Analysis

As we can infer from the above figure, the time in performing this task is fairly small, only takes about 1000 ms to 2000 ms. And we cannot see any performance gain by using multi-thread methods. I think the reason is the same as mentioned in the former test methods that the lock in the database prohibits the multiple threads from enterring into its critical section.

###Join Table Performance


###Relation Mapping
- Relational design in MySQL
<table border=0 style="border-collapse:collapse;">
  <thead>
 　<th>one to many</th><th>many to many</th>
  </thead>
 <tr>
  <td><img src="img/one_to_many.jpg" /></td>
  <td><img src="img/many_to_many.jpg"></td>
 </tr>
</table>
- Embedded document in MongoDB
 In MongoDB,  we would apply following model structure to represent one to many relation.
<pre><code>
{
	"_id":
	"name":
	"password":
	"requestList":{
		{ 
		   "_id":
		   "comment":
		   "house":{
		   	  "_id":
		   	  "name":
		   	  "type":
		   }
		},
		{ 
		   "_id":
		   "comment":
		   "house":{
		   	  "_id":
		   	  "name":
		   	  "type":
		   }
		}
	}
}

</code></pre>
##### Search in mulitple tables in MySQL
In MySQL, we must define separate tables to represent different models and each column should be the smallest unit.
To associate the relationship between tables,  foreign key or join table are applied under the schema. In this scenario, 
searching in MySQL involves several tables using complicated query like join. 
###### Data
<table border=0 style="border-collapse:collapse;">
  <thead>
 　<th>#Records<br>
 (request*100)</th>
 　<th>100</th>
 　<th>1000</th>
 <th>10000</th>
  </thead>
 <tr>
  <td>user+request</td>
  <td>73</td>
  <td>597</td>
  <td>4937</td>
 </tr>
 <tr>
  <td>reqeust+house_request+house</td>
  <td>456</td>
  <td>7473</td>
  <td>88244</td>
 </tr>
</table>

The records is the size of "house" and "user" table, each house and user record associated with 100 requests. To search a user's request list, using the sql "select * from request where user_id=?". To map the relation between request and house, MySQL supports join table and the sql would be like this "select * from request inner join house_request on request.id=house_request.request_id inner join house on house.id=house_request.house_id where house.id=?" 				                                   				                                				                                     
###### Analysis
As we can see, searching requests responding to house takes 10+ times than searching user's requests. Notice that when records of user and house is 10000, the request table size is 100*10000. Querying user's requests only search in the "request" table while  house's requests would take 2 join operations which consumes large time. The result of join even generates larger size of result set. Query in that result set pretends to be extremely slow. Generally, query across multiple tables using sql operations would take much time than single table. The situation get worse when these table scaling up. 
##### Search in embedded document in MongoDB
In MongoDB, each collection is stored as document. Each coloumn inside a collection also could be a collection. So we could use nested collections to store the relationship inside the document.
A huge advantage over SQL when searching in MongoDB is only inside one document without joining.
###### Data
<table border=0 style="border-collapse:collapse;">
  <thead>
 　<th>#Records</th>
 　<th>100</th>
 　<th>1000</th>
 　<th>10000</th>
 　<th>100000</th>
  </thead>
 <tr>
  <td>user</td>
  <td>82</td>
  <td>56</td>
  <td>95</td>
  <td>103</td>
 </tr>
 <tr>
  <td>user.requestList</td>
  <td>42</td>
  <td>102</td>
  <td>1407</td>
  <td>22778</td>
 </tr>
 <tr>
  <td>user.requestList.house</td>
  <td>45</td>
  <td>112</td>
  <td>1891</td>
  <td>72789</td>
 </tr>
</table>

In MongoDB, each user record contains a size of 100 requestList collection. We search on 3 level in user collection. First we search a specific user on name using query "{'name':?}". Then we compared with query in embedded collection using embedded query "{'requestList.comment':?}". Further query on embedded collection inside requestList.house  by using query "{'requestList.house.name':?}".
###### Analysis
There is no extra effort to find user's requests when we find a specific user and varies a little when scaling up. Any search takes in single collection. But with embedded query, searching would happen in each embedded collections inside the document. 
<br>
Using the embedded collection, it is hard to find a set of requests responding to a specific house. We can insert such a embedded request collection inside the house collection which causes duplicate records on request. In this schema, the document with embedded collections also takes more space in disk and may causes split because the maximum document size in mongoDB is 16MB. To avoid this, We would expect a small size of embedded collection.

##Discussion

- We have spotted that the Multi-thread bottle-neck in the Find test of MongoDB. However, we don't think it should be as NoSQL database definitely prevails SQL database when it deals with the massive distributed thing, eg. big data, big numbers of users, big numbers of computers, big supply chains, big science, and so on. Therefore, we are thinking if our dataset are too small compared to the BIG thing, which is the reason why adding more threads are not giving more performance improvement. It should have an overwhelming improvement when its scale get expanded by using more infrastructure such as a cluster of NoSQL server.

##Conclusion
####Multi-threaded Performance

- As we can see from the above Section, implementing multiple threads in insertion and deletion in Mongo like NoSQL database on a single instance has little improvement on time factors. However, this method have signficant influence on query performance, even on a single instance, the performance could be improved by at least 50%. More improvement could be achieved by utilizing expanded scale of cluster servers. 

#### Data Association
Association in MySQL always require extra column or table to store key of related table. It is low efficient when query happens across multiple tables using complicated SQL. We have to avoid unnecessary join with different large size tables. MongoDB achieved this by using embedded collection. The association data is stored inside the document and much faster to locate without query for other documents. It may sacrifice extra space to achieve high efficiency in query.
<br>
In a scenario that requires much relational design, it is needed in MySQL to strictly define the structure of tables. With dynamic SQL query, we could easily associated data and map the relation. And MongoDB is hard to express the relations between different collections without SQL. But in a less related and huge scale scenario, query is expected inside single table which SQL lost its power. MongoDB is more suit using embedded structure and flexible to future extension in data model. 

##Future Work
- Hardware Extension
MySQL consumes large volume of hardware resource, it is expected a improvement in performance with hardware improvement. MongoDB also support distributed deployment which database run in multiple nodes. The performance is expected different with single node.   

##References



