# SpannableStringBuilder Extensions

## General
The library adds a couple of methods that make it easy to create modifiable text: bold text; text with colored nested parts, and more.

## Preview
```kotlin
val textView = findViewById<TextView>(R.id.text_view)
val spannableText = SpannableStringBuilder()
    .append("This is an example with ")
    .appendBold("Bold Text")
textView.text = spannableText
```

<p align="center">
  <img src="https://github.com/viacheslav-chugunov/spannablestringbuilder-extensions/blob/main/assets/example_1.png" >
</p>

```kotlin
val textView = findViewById<TextView>(R.id.text_view)
val spannableText = SpannableStringBuilder()
    .append("This is an example with ")
    .appendBold("Bold Text")
    .append(" and ")
    .append { colorHex("#CC0000") { italic { "red italic" } } }
textView.text = spannableText
```

<p align="center">
  <img src="https://github.com/viacheslav-chugunov/spannablestringbuilder-extensions/blob/main/assets/example_2.png" >
</p>

## Gradle
Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.viacheslav-chugunov:spannablestringbuilder-extensions:1.0.2'
}
```

## Maven
Step 1. Add the JitPack repository to your build file
```maven
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
```maven
<dependency>
    <groupId>com.github.viacheslav-chugunov</groupId>
    <artifactId>spannablestringbuilder-extensions</artifactId>
    <version>1.0.2</version>
</dependency>
```
