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


## Basic Instruction

### model
- model is a database table.

### @Entity
- Entity is model decorator (@Entity).

### @Column
- literally Column
- explicitely specifying a column type into the @Column is possible (Xolumn sㄱ rypwa)

### @Primary Coumn
- Each entity must have at least one primary key column

### @PrimaryGeneratedColumn
- auto generate primary column (ex. id // auto-increment / sequence / serial generated identity column)

### Entity Manager / Repository
- entity manager can manipulate any entity
- repository can manipulate its entity

### @OneToOne
- type: a function which returns the class of the entity with which we want to make our relationship 
- ex. type => CLASS A

### @JoinColumn
- indicates that this side of the relationship will own the relationship
- relations can be unidirectional or bidirectional
- Only one side of relational can be owning
- Using @JoinColumn deccorator is required on the owner side of the relationship
- THe owning side of a relationship contains a column with a foreign key in the database

### Inverse side of the relationship
- let owned entity to access its owner entity

### loading objects with their relations
- relations in find options with entityName: true
- queryBuilder > innerJoinAndSelect

### Cascades to automatically save related objests in @OneToOne
ex. 
```javascript
export class Photo {
    /// ... other columns

    @OneToOne(() => PhotoMetadata, (metadata) => metadata.photo, {
        cascade: true,
    })
    metadata: PhotoMetadata
}
```
