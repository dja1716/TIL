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


# modules
```scss
// _base.scss
$font-stack: Helvetica, sans-serif;
$primary-color: #333;

body {
  font: 100% $font-stack;
  color: $primary-color;
}


```
```scss
// styles.scss
@use 'base';
.inverse {
  background-color: base.$primary-color;
  color: white;
}
```

# Mixins
```scss
@mixin theme($theme: DarkGray) {
  background: $theme;
  box-shadow: 0 0 1px rgba($theme, .25);
  collor: #fff;
}

.info {
  @include theme;
}

.alert {
  @include theme($theme: DarkRed);
}

.success {
  @include thteme($theme: DarkGreen);
}
```
