# Springboot-Microservices-Transactions
Sample microservices implementaion using springboot<br>

Tech Stack: SpringBoot, H2 in-memory database.


# Design

![image](https://user-images.githubusercontent.com/62506255/162711276-ff0575f3-f06e-4a50-a779-d36a9619c29c.png)

User will be able to post transactions to Bank API and the Bank API will encrypt the transaction data and will post it to TransactionQ API<br>
TransactionQ API decrypts the recieved transaction and adds it to H2 in-memory database.<br>

Transaction Object: 
```
{
	"accountNumber":"12334555",
	"type":"Credit",
	"amount":100,
	"currency":"INR",
	"accountFrom":"84589425"
}
```

Encryption method used is [The Advanced Encryption Standard](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)<br>

# Database
H2 in memory database.
![image](https://user-images.githubusercontent.com/62506255/162713150-f1d73505-5ee2-4e5d-817c-5f9e1288a62c.png)

# Build steps

As the project contains two services, one has to build and run two services(Bank and TransactionQ). Here are the steps to build and run Bank API.

 - step:1<br>
Using IDE<br>
Open Bank folder -> right Click on pom.xml -> Run As -> Maven build -> Goals:package -> apply -> Run.<br>
Using command line<br>
 Open Bank folder -> `mvn clean package`<br>

Any of the above steps will create an executable JAR file in the target folder.<br>
 - step:2<br>
Now run the executable jar file using command line `java -jar target/<executable-bank-jar-name>.jar`<br>

Similarly run TransactionQ API. Now both the services are up and running.

Port details:
```
Bank: 8083
TransactionQ: 8082

POST {transaction} to http://localhost:8083/transactions
```
