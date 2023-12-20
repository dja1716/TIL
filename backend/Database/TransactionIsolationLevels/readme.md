### STUDY REFERENCE: 
https://fauna.com/blog/introduction-to-transaction-isolation-levels#perfect-isolation <br />
https://en.wikipedia.org/wiki/Serializability <br />
https://blog.bytebytego.com/p/free-system-design-pdf-158-pages <br />
https://medium.com/myinterest/%EB%8F%99%EC%8B%9C%EC%84%B1-%EC%A0%9C%EC%96%B4-%EA%B8%B0%EB%B2%95%EC%9D%98-anomaly-bad-dependency-306c9c25a4f9 <br />
https://incheol-jung.gitbook.io/docs/q-and-a/db/isolation-level

# Transaction Isolation Levels


## Introduction


* Isolation Levels
  * Serializability (High Isolation Level)
  * Read Committed
  * Read Uncommitted (Low Isolation Level)


* Sticking with the default isolation level of database system is not good -> should consider which isolation level is optimal for the application


* the majority of widely-used database systems including PostgreSQL (which I'm using now) do not guarantee any flavor of serializability


* (of course), isolation levels weaker than serializability can lead to concurrency bugs in an application and negative user experiences


* There are more types of levels (ex, strict serializability, one-copy serializability)


* What is Serializability? Serializability is the major corrrectness criterion for concurrent transactions' executions


## What is an Isolation Level?


* Database isolation - the ability of a database to allow a transaction to execute as if there are no other concurrently running transactions (actually, there is a lot of concurrent transactions


* the goal of database isolation is to prevent reads and writes of temporary, aborted, or incorrect database written by concurrent transactions


* Perfect database isolation comes as a performance cost in terms of transaction latency


* In poorly designed systems, achieving perfection comes with a prohibitive performance cost.


* Database isolation is not a magic solution for performance.


## Perfect Isolation (Serializability)


* code is run serially one after the other
  * can achieved via locking, validation or multi-versioning


* It may appear that perfection is impossible. If two transactions both read and write the same data item, it is critical that they impact each other.
  * ex, when (concurrent) trancations ignore each other, whichever transaction completes the write last could clobber the first transaction, resulting in the same final state as if it never ran


* Ensuring correctness of code when there are no other concurrent processes running in the system is non-trivial
  * when above correctness is ensured, a system that guarantees perfect isolation will ensure that the code remains correct even when there is other code running concurrently in the system


* ex, one copy-serializability (1SR), strict serializability (strict 1SR) or update serializability (US)
  * strict serializability is the most perfect


## Anomalies in Concurrent Systems

* lost-update anomaly
  * ex, transaction1's write overwritten.

![스크린샷 2022-11-15 오후 7 49 20](https://user-images.githubusercontent.com/20631646/201901423-5781ff76-1144-40a0-935a-452dfac4e3de.png)


* dirty-read anomaly
  * ex, reading non-existing data
![스크린샷 2022-11-15 오후 7 52 02](https://user-images.githubusercontent.com/20631646/201902117-62256858-257e-42b5-9205-a9a28b7ff63a.png)


* Unrepeatable Read
  * same SELECT query results differ (similary with Phantom Read)

![스크린샷 2022-11-15 오후 8 01 01](https://user-images.githubusercontent.com/20631646/201903912-ed34e954-3272-4dc0-a0e5-223e054c1aff.png)


* Phantom Read
  * same SELECT query results differ (similary with Phantom Read)

![스크린샷 2022-11-15 오후 8 04 25](https://user-images.githubusercontent.com/20631646/201904570-b37f9b7d-793d-4d07-9c94-358f410c6f81.png)


## Definitions in the ISO SQL Standard

![스크린샷 2022-11-15 오후 8 10 15](https://user-images.githubusercontent.com/20631646/201905488-195adbb9-c24f-45ec-9fe5-64f99a24976d.png)


## Possible Problems

1. there are more than other concurrency bugs than above chart covers
2. using anomalies to define isolation levels only gives the end user a guarantee of what specific types of concurrency bugs are impossible.

The bottom line is this: it is nearly impossible to give clear definitions of the actual isolation levels available to application developers, because vagueness and ambiguities in the SQL standard has led to semantic differences across implementations/systems


### I got curious that if I can optimize sql transactions on current and future backend system (Nest Js)



