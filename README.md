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

## Usage
### SpannableStringBuilder extensions
```kotlin
// Appends bold text
fun SpannableStringBuilder.appendBold(text: CharSequence): SpannableStringBuilder

// Appends italic text
fun SpannableStringBuilder.appendItalic(text: CharSequence): SpannableStringBuilder

// Appends underlined text
fun SpannableStringBuilder.appendUnderline(text: CharSequence): SpannableStringBuilder

// Appends painted text
fun SpannableStringBuilder.appendColorHex(colorHex: String, text: CharSequence): SpannableStringBuilder
fun SpannableStringBuilder.appendColorInt(@ColorInt colorInt: Int, text: CharSequence): SpannableStringBuilder
fun SpannableStringBuilder.appendColorRes(context: Context, @ColorRes colorRes: Int, text: CharSequence): SpannableStringBuilder

// Appends html text
fun SpannableStringBuilder.appendHtml(startTag: String, text: CharSequence, endTag: String): SpannableStringBuilder

// Builder to append text, modified two or more times
fun SpannableStringBuilder.append(builder: SpannableStringBuilderScope.() -> CharSequence): SpannableStringBuilder
```
### SpannableStringBuilderScope
```kotlin
// Makes wrapped text bold
fun bold(provideText: () -> CharSequence): CharSequence

// Makes wrapped text italic
fun italic(provideText: () -> CharSequence): CharSequence

// Makes wrapped text underlined
fun underline(provideText: () -> CharSequence): CharSequence

// Paints wrapped text
fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence
fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence
fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence

// Wraps text in html tags
fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence
```

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
