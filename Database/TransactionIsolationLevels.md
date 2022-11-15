### STUDY REFERENCE: https://fauna.com/blog/introduction-to-transaction-isolation-levels#perfect-isolation

# Transaction Isolation Levels

* Isolation Levels


- Serializability (High Isolation Level)
- Read Committed
- Read Uncommitted (Low Isolation Level)


* Sticking with the default isolation level of database system is not good -> should consider which isolation level is optimal for the application


* the majority of widely-used database systems including PostgreSQL (which I'm using now) do not guarantee any flavor of serializability


* (of course), isolation levels weaker than serializability can lead to concurrency bugs in an application and negative user experiences


* 







### I got curious that if I can optimize sql transactions on current and future backend system (Nest Js)



