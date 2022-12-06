## Postgresql
* ALTER TYPE enum ADD VALUE 'new value'
  * add new value to enumType
* ALTER TYPE enum_type ADD VALUE 'new_value' BEFORE 'old_value';
* ALTER TYPE enum_type ADD VALUE 'new_value' AFTER 'old_value';
```postgresql
ALTER TYPE application_status_enum ADD VALUE 'CancelRequested'
```
