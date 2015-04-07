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


In order to compare single thread performance of SQL and NoSQL databases, we choose MySQL(SQL) and MongoDB(NoSQL) to test add, find and delete performance by comparing their time cost. We have used different numbers of records and strategies to compare the performance between SQL and NoSQL.

####Single Thread Add Performance Comparison

To test the add performance of MySQL and MongoDB, we had used a method of adding different size of records into database and compared their time cost. The number of records  changes from 1000 to 200000, and we divided them into 9 groups and test their executing time by adding the same number of records into two databases at each time. 

######Data
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
<td align="left">703</td>
<td align="left">2742</td>
<td align="left">3089</td>
<td align="left">5425</td>
<td align="left">10452</td>
<td align="left">15705</td>
<td align="left">23175</td>
<td align="left">29037</td>
<td align="left">37783</td>
</tr>
</tbody>
</table>

We have tested 9 groups of records,  and the number of records is from 1000 to 200000 (See Table). The data in the first row stands for different size of records, and the data in the second and third rows are time cost of adding different number of records into MongoDB and MySQL.

######Figure

<img src="img/single_add.png"/>

######Analysis

According to above diagram, we can see MongoDB's line is under MySQL's line. It means MongoDB is faster than MySQL when adding the same size of records into databases. Based on above test results, we conclude that MongoDB's adding performance is better than MySQL's adding performance.


####Single Thread Find Performance Comparison I

We have adopted two methods to test the find performance of MySQL and MongoDB. One method is to test the time cost of finding different number of records from databases, in this case, the the number of records in the databases are fixed (200000). The other method is to test the time cost of finding fixed records (5000) from databases, the number of records in databases increases from 5000 to 200000. 

######Data
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
<td align="left">1369</td>
<td align="left">1049</td>
<td align="left">2827</td>
<td align="left">3647</td>
<td align="left">5775</td>
<td align="left">10865</td>
<td align="left">15659</td>
<td align="left">18071</td>
<td align="left">28114</td>   
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left">15</td>
<td align="left">74</td>
<td align="left">136</td>
<td align="left">247</td>
<td align="left">320</td>
<td align="left">413</td>
<td align="left">449</td>
<td align="left">505</td>
<td align="left">561</td>
</tr>
</tbody>
</table>

We have tested 9 groups of data,  and the numbers of records change from 1000 to 200000 (See Table). The data in the first row stands for different records' size, and each column between the second and third rows stands for time cost of finding the same number of records from MongoDB and MySQL.

######Figure

<img src="img/single_find_1.png"/>

######Analysis

According to above diagram, the line of MongoDB is over the line of MySQL. It means that MySQL is faster than MongoDB when finding the same number of records in the databases which also have same number of records.  We also see that the line of MySQL grows very slow when finding the increasing number of records from fixed number of records in the database, which implies that MySQL has little variance to find the different number of records from same size of records in the database. 

####Single Thread Find Performance Comparison II

######Data
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
<td align="left">5000</td>
<td align="left">10000</td>
<td align="left">20000</td>
<td align="left">40000</td>
<td align="left">80000</td>
<td align="left">120000</td>
<td align="left">160000</td>
<td align="left">200000</td>
</tr>
</thead>    
<tbody>
<tr class="odd">
<td align="left">MongoDB</td>
<td align="left">1979</td>
<td align="left">2310</td>
<td align="left">1774</td>
<td align="left">1921</td>
<td align="left">2166</td>
<td align="left">1944</td>
<td align="left">2525</td>
<td align="left">1889</td>
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left">138</td>
<td align="left">110</td>
<td align="left">72</td>
<td align="left">69</td>
<td align="left">76</td>
<td align="left">74</td>
<td align="left">74</td>
<td align="left">75</td>
</tr>
</tbody>
</table>

We have tested 8 groups of data. The data in the first row stands for different records' size, and each column between the second and third rows stands for time cost of finding 5000 records from databases which have different numbers of records from 5000 to 200000 (See Table).

######Figure

<img src="img/single_find_2.png"/>

######Analysis

According to above diagram, the line of MongoDB is over the line of MySQL. It means that MySQL is faster than MongoDB when finding 5000 records from databases as the number of records increase in the databases .  We also see that the line of MySQL is smooth and level when they find a fixed number of records from increasing number of records in the database, which implies that MySQL has little variance to find the fixed number of records from database. 

####Single Thread Delete Performance Comparison I

In order to test the delete performance of MySQL and MongoDB, we adopt two strategies to test their time cost. One way is to randomly delete fixed number of records from varied data size in databases, the other way is to randomly delete varied number of records from fixed records from databases. 

######Data
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
<td align="left">192</td>
<td align="left">697</td>
<td align="left">1167</td>
<td align="left">1688</td>
<td align="left">3221</td>
<td align="left">4535</td>
<td align="left">6310</td>
<td align="left">9147</td>
<td align="left">12319</td>     
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left">847</td>
<td align="left">1947</td>
<td align="left">2449</td>
<td align="left">4478</td>
<td align="left">8054</td>
<td align="left">11940</td>
<td align="left">15842</td>
<td align="left">19022</td>
<td align="left">21822</td>   
</tr>
</tbody>
</table>

We have tested 9 groups of data. The data in the first row stands for different records' size of finding from databases, and each column between the second and third rows stands for time cost when finding the same number of records from MongoDB and MySQL.

######Figure

<img src="img/single_del_1.png"/>

######Analysis

According to the above diagram, the line of MongoDB is under the line of MySQL. It means that MongoDB is faster than MySQL when they delete different number of records from databases which have fixed number of records(200000). 
          
####Single Thread Delete Performance Comparison II

######Data
<table>
<thead>
<tr class="header">
<th align="left">#Records</th>
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
<td align="left">1035</td>
<td align="left">673</td>
<td align="left">624</td>
<td align="left">641</td>
<td align="left">568</td>
<td align="left">638</td>
<td align="left">621</td>
<td align="left">587</td>     
</tr>
<tr class="even">
<td align="left">MySQL</td>
<td align="left">1073</td>
<td align="left">1144</td>
<td align="left">1391</td>
<td align="left">1570</td>
<td align="left">1493</td>
<td align="left">1800</td>
<td align="left">1652</td>
<td align="left">1947</td>    
</tr>
</tbody>
</table>
          
We have tested 8 groups of data. The data in the first row stands for different records size from 5000 to 20000 in the databases, and each column between the second and third rows stands for time cost of finding 5000 records from databases based on different size of records in database. (See Table).

######Figure

<img src="img/single_del_2.png"/>

######Analysis

According to above diagram, the blue line of MongoDB is under the the red line of MySQL. It means MongoDB has a better performance than MySQL, when they delete the same number of records (5000) from databases with varied number of records.

###Multi-Thread Test

####Multi-Thread Add Performance

#####Data
<table>
<thead>
<tr class="header">
<th align="left">#Threads</th>
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
<td align="left">1103</td>
<td align="left">4637</td>
<td align="left">6787</td>
<td align="left">8840</td>
<td align="left">15147</td>
<td align="left">15079</td>
<td align="left">18791</td>
<td align="left">23146</td>
<td align="left">28319</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">1044</td>
<td align="left">5208</td>
<td align="left">7974</td>
<td align="left">11911</td>
<td align="left">17051</td>
<td align="left">18529</td>
<td align="left">22080</td>
<td align="left">26255</td>
<td align="left">28989</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">941</td>
<td align="left">5707</td>
<td align="left">9840</td>
<td align="left">13806</td>
<td align="left">18291</td>
<td align="left">21993</td>
<td align="left">24250</td>
<td align="left">28987</td>
<td align="left">31345</td>
</tr>
</tbody>
</table>

#####Figure

#####Analysis

####Multi-Thread Find Performance

##### Find Performance Test I
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
<td align="left">478</td>
<td align="left">2159</td>
<td align="left">3598</td>
<td align="left">6058</td>
<td align="left">7392</td>
<td align="left">13443</td>
<td align="left">16516</td>
<td align="left">22291</td>
<td align="left">24557</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">379</td>
<td align="left">1666</td>
<td align="left">3104</td>
<td align="left">5193</td>
<td align="left">8803</td>
<td align="left">12079</td>
<td align="left">19512</td>
<td align="left">20013</td>
<td align="left">26154</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">314</td>
<td align="left">1408</td>
<td align="left">2514</td>
<td align="left">5019</td>
<td align="left">7465</td>
<td align="left">13822</td>
<td align="left">17659</td>
<td align="left">19349</td>
<td align="left">25642</td>
</tr>
</tbody>
</table>

######Figure
######Analysis

##### Find Performance Test II
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
<td align="left">2494</td>
<td align="left">2700</td>
<td align="left">2434</td>
<td align="left">2472</td>
<td align="left">3456</td>
<td align="left">2876</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">1875</td>
<td align="left">2032</td>
<td align="left">1890</td>
<td align="left">2302</td>
<td align="left">2646</td>
<td align="left">2023</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">1647</td>
<td align="left">1433</td>
<td align="left">1524</td>
<td align="left">1480</td>
<td align="left">1525</td>
<td align="left">1653</td>
</tr>
</tbody>
</table>
######Figure
######Analysis


####Multi-Thread Delete Performance

##### Delete Performance Test I
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
<td align="left">231</td>
<td align="left">816</td>
<td align="left">1460</td>
<td align="left">2840</td>
<td align="left">3673</td>
<td align="left">5913</td>
<td align="left">18427</td>
<td align="left">24890</td>
<td align="left">29295</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">277</td>
<td align="left">783</td>
<td align="left">1511</td>
<td align="left">2220</td>
<td align="left">5261</td>
<td align="left">9938</td>
<td align="left">20535</td>
<td align="left">28330</td>
<td align="left">32314</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">215</td>
<td align="left">998</td>
<td align="left">1251</td>
<td align="left">2079</td>
<td align="left">3778</td>
<td align="left">15499</td>
<td align="left">21391</td>
<td align="left">21308</td>
<td align="left">25748</td>
</tr>
</tbody>
</table>

######Figure

<img src="img/multi_del_1.png"/>

######Analysis


##### Delete Performance Test II
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
<td align="left">1186</td>
<td align="left">1362</td>
<td align="left">976</td>
<td align="left">1662</td>
<td align="left">1533</td>
<td align="left">882</td>
<td align="left">1005</td>
</tr>
<tr class="odd">
<td align="left">4 Threads</td>
<td align="left">1274</td>
<td align="left">1189</td>
<td align="left">858</td>
<td align="left">1250</td>
<td align="left">1238</td>
<td align="left">799</td>
<td align="left">904</td>
</tr>
<tr class="even">
<td align="left">8 Threads</td>
<td align="left">1043</td>
<td align="left">1100</td>
<td align="left">813</td>
<td align="left">1042</td>
<td align="left">891</td>
<td align="left">971</td>
<td align="left">993</td>
</tr>
</tbody>
</table>
######Figure

<img src="img/multi_del_2.png"/>

######Analysis

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
- Embedded collections in MongoDB

##### Search in mulitple tables in MySQL
<table border=0 style="border-collapse:collapse;">
  <thead>
 　<th>#Records</th><th>many to many</th>
  </thead>
 <tr>
  <td>user's request<br>
   user+request</td>
  <td></td>
 </tr>
 <tr>
  <td>house's request<br>
   reqeust+house_request+house</td>
  <td></td>
 </tr>
</table>
##### Search in nested collections in MongoDB
##Discussion

##Conclusion

##Future Work

##References



