# variable
```scss
$primary-font: Helvetica, sans-serif;
$primary-color: #333;

body {
  font: 100% $primary-font;
  color: $primary-color;
}
```

# nesting
```scss
nav {
  ul {
    margin: 0;
    padding: 0;
    list-style: none;
  }
  
  li { display: inline-block; }
  
  a {
    display: block;
    padding: 6px 12px;
    text-decoration: none;
  }
}
```
