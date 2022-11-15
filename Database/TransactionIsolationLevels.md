### STUDY REFERENCE: 
https://fauna.com/blog/introduction-to-transaction-isolation-levels#perfect-isolation <br />
https://en.wikipedia.org/wiki/Serializability <br />
https://blog.bytebytego.com/p/free-system-design-pdf-158-pages <br />

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




### I got curious that if I can optimize sql transactions on current and future backend system (Nest Js)



