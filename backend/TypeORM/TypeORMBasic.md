### Reference:
https://gongmeda.tistory.com/51 <br />
https://typeorm.io/ <br />

# what is typeORM?

## what is ORM?
-  ORM means Object Relational Mapping
-  map objects with data in database automatically
-  based on, relations among objects, it creates sql automatically.


## why do we use ORM?
-  NestJS is designed to code object-orientedly
-  Application (object-oriented) <-> DB (Table)


## weakness of ORM
-  As logic get complicated, ORM's optimization becomes not enough.
-  For complicated queries, creating SQL by own is better


## Basic Structure

### model
- model is a database table.

### @Entity
- Entity is model decorator (@Entity).

### @Column
- literally Column
- explicitely specifying a column type into the @Column is possible


### @Primary Coumn
- Each entity must have at least one primary key column


### @PrimaryGeneratedColumn
- auto generate primary column (ex. id // auto-increment / sequence / serial generated identity column)
