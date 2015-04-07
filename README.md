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
  </thead>
 <tr>
  <td>user+request</td>
  <td>73</td>
  <td>597</td>
 </tr>
 <tr>
  <td>reqeust+house_request+house</td>
  <td>456</td>
  <td>7473</td>
 </tr>
</table>

###### Analysis
##### Search in nested collections in MongoDB
In MongoDB, each coloumn in a collection also could be a collection. So we could use nested collections to store the relationship inside the document.
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
###### Analysis

##Discussion

##Conclusion

##Future Work

##References



