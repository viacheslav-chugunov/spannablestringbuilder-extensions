package viacheslav.chugunov.spannablestringbuilder.extensions

import android.text.Html
import android.text.SpannableStringBuilder
import viacheslav.chugunov.spannablestringbuilder.scope.DefaultSpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope

inline fun SpannableStringBuilder.append(
    builder: SpannableStringBuilderScope.() -> CharSequence,
) = append(DefaultSpannableStringBuilderScope(), builder)

inline fun <T : SpannableStringBuilderScope> SpannableStringBuilder.append(
    scope: T,
    builder: T.() -> CharSequence,
): SpannableStringBuilder {
    val textString = builder(scope).toString()
    val spannedText = Html.fromHtml(textString)
    return append(spannedText)
}