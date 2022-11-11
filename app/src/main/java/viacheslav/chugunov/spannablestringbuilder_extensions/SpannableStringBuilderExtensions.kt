package viacheslav.chugunov.spannablestringbuilder_extensions

import android.text.Html
import android.text.SpannableStringBuilder

inline fun SpannableStringBuilder.append(
    builder: SpannableStringBuilderScope.() -> CharSequence,
) = append(builder, SpannableStringBuilderScope.Default())

inline fun SpannableStringBuilder.append(
    builder: SpannableStringBuilderScope.() -> CharSequence,
    scope: SpannableStringBuilderScope
): SpannableStringBuilder {
    val textString = builder(scope).toString()
    val spannedText = Html.fromHtml(textString)
    return append(spannedText)
}