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

# extend/inheritance
```scss
/* This CSS will print because @message-shared is extended. */
%message-shared {
  border: 1px solid #ccc;
  padding: 10px;
  color: #333;
}

// This CSS won't print because %equal-heights is never extended.
%equal-heights {
  display: flex;
  flex-wrap: wrap;
}

.message {
  @extend %message-shared;
}

.success {
  @extend %message-shared;
  border-color: green;
}

.error {
  @extend %message-shared;
  border-color: red;
}

.warning {
  @extend %message-shared;
  border-color: yellow;
}
```

```css
/* This CSS will print because %message-shared is extended. */
.message, .success, .error, .warning {
  border: 1px solid #ccc;
  padding: 10px;
  color: #333;
}

.success {
  border-color: green;
}

.error {
  border-color: red;
}

.warning {
  border-color: yellow;
}
```

# Operators
```scss
@use "sass:math";

.container {
  display: flex;
}

article[role="main"] {
  width: math.div(600px, 960px) * 100%;
}

aside[role="complementary"] {
  width: math.div(300px, 960px) * 100%;
  margin-left: auto;
}
```

```css
```
