package viacheslav.chugunov.spannablestringbuilder.extensions

import android.text.Html
import android.text.SpannableStringBuilder
import viacheslav.chugunov.spannablestringbuilder.scope.DefaultSpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope

/**
 * Extension function allows you to modify part of the text. This function adds text to an existing
 * one similar to SpannableStringBuilder.append.
 * @param builder function in which you can modify text or part of it.
 * @see SpannableStringBuilderScope
 * @see SpannableStringBuilder.append
 * @return builder with added text.
 * */
inline fun SpannableStringBuilder.append(
    builder: SpannableStringBuilderScope.() -> CharSequence
): SpannableStringBuilder = append(DefaultSpannableStringBuilderScope(), builder)

/**
 * Extension function allows you to modify part of the text. This function adds text to an existing
 * one similar to SpannableStringBuilder.append. Also here you can pass custom SpannableStringBuilderScope
 * to expand the functionality of DefaultSpannableStringBuilderScope.
 * @param scope scope, which can be used to modify text.
 * @param builder function in which you can modify text or part of it.
 * @see SpannableStringBuilderScope
 * @see SpannableStringBuilder.append
 * @see DefaultSpannableStringBuilderScope
 * @return builder with added text.
 * */
inline fun <T : SpannableStringBuilderScope> SpannableStringBuilder.append(
    scope: T,
    builder: T.() -> CharSequence
): SpannableStringBuilder {
    val textString = builder(scope).toString()
    val spannedText = Html.fromHtml(textString)
    return append(spannedText)
}

/**
 * Extension function that allows you to add "\n" to the end of a line.
 * @return builder with added text.
 * */
fun SpannableStringBuilder.newLine(): SpannableStringBuilder = append("\n")