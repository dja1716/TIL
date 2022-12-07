### Reference:
https://stackoverflow.com/questions/1771543/adding-a-new-value-to-an-existing-enum-type <br />

## Postgresql
* ALTER TYPE enum ADD VALUE 'new value'
  * add new value to enumType
* ALTER TYPE enum_type ADD VALUE 'new_value' BEFORE 'old_value';
* ALTER TYPE enum_type ADD VALUE 'new_value' AFTER 'old_value';
```postgresql
ALTER TYPE application_status_enum ADD VALUE 'CancelRequested'
```

```postgresql
-- 1. rename the enum type you want to change
alter type some_enum_type rename to _some_enum_type;
-- 2. create new type
create type some_enum_type as enum ('old', 'values', 'and', 'new', 'ones');
-- 3. rename column(s) which uses our enum type
alter table some_table rename column some_column to _some_column;
-- 4. add new column of new type
alter table some_table add some_column some_enum_type not null default 'new';
-- 5. copy values to the new column
update some_table set some_column = _some_column::text::some_enum_type;
-- 6. remove old column and type
alter table some_table drop column _some_column;
drop type _some_enum_type;
```
### Deleting a single value of an existing enum
* need to set no default to change
```postgresql
create type application_status_enum_new as enum ('Disapproved', 'Approved', 'Pending', 'Enrolled');

ALTER TABLE applications 
  ALTER COLUMN status TYPE application_status_enum_new 
    USING (status::text::application_status_enum_new );
    
drop type application_status_enum;

alter type application_status_enum_new  rename to application_status_enum
```
