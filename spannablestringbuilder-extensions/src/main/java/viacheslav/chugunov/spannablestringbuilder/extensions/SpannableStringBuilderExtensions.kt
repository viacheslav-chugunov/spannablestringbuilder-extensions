package viacheslav.chugunov.spannablestringbuilder.extensions

import android.content.Context
import android.content.res.Resources.NotFoundException
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import viacheslav.chugunov.spannablestringbuilder.scope.DefaultSpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.util.IllegalColorHexException
import viacheslav.chugunov.spannablestringbuilder.util.IllegalHtmlTagsException

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
 * Appends bold text.
 * @param text text that should be modified.
 * @return builder with added bold text.
 * */
fun SpannableStringBuilder.appendBold(text: CharSequence): SpannableStringBuilder =
    append { bold { text } }

/**
 * Appends italic text.
 * @param text text that should be modified.
 * @return builder with added italic text.
 * */
fun SpannableStringBuilder.appendItalic(text: CharSequence): SpannableStringBuilder =
    append { italic { text } }

/**
 * Appends underlined text.
 * @param text text that should be modified.
 * @return builder with added underlined text.
 * */
fun SpannableStringBuilder.appendUnderline(text: CharSequence): SpannableStringBuilder =
    append { underline { text } }

/**
 * Appends text, painted in selected color.
 * @param colorHex color in hex a format. Valid format is #FFFFFF.
 * @param text text that should be modified.
 * @throws IllegalColorHexException if the text is in the wrong format.
 * @return builder with added painted text.
 * */
fun SpannableStringBuilder.appendColorHex(colorHex: String, text: CharSequence): SpannableStringBuilder =
    append { colorHex(colorHex) { text } }

/**
 * Appends text, painted in selected color.
 * @param colorInt int value of the text.
 * @param text text that should be modified.
 * @return builder with added painted text.
 * */
fun SpannableStringBuilder.appendColorInt(@ColorInt colorInt: Int, text: CharSequence): SpannableStringBuilder =
    append { colorInt(colorInt) { text } }

/**
 * Appends text, painted in selected color.
 * @param context application context.
 * @param colorRes resource of the text.
 * @param text text that should be modified.
 * @throws NotFoundException if the color resource is invalid.
 * @return builder with added painted text.
 * */
fun SpannableStringBuilder.appendColorRes(context: Context, @ColorRes colorRes: Int, text: CharSequence): SpannableStringBuilder =
    append { colorRes(context, colorRes) { text } }
/**
 * Appends text, modified by html tags.
 * @param startTag left html tag. Valid format is <h1>.
 * @param endTag right html tag. Valid format is </h1>.
 * @param text text that should be modified.
 * @throws IllegalHtmlTagsException if the tags are in the wrong format.
 * @return builder with added html text.
 * */
fun SpannableStringBuilder.appendHtml(startTag: String, text: CharSequence, endTag: String): SpannableStringBuilder =
    append { html(startTag, endTag) { text } }

/**
 * Extension function allows you to modify part of the text. This function adds text to an existing
 * one similar to SpannableStringBuilder.append. Also here you can pass custom SpannableStringBuilderScope
 * to expand the functionality of DefaultSpannableStringBuilderScope.
 * @param scope scope, which can be used to modify text.
 * @param builder function in which you can modify text or part of it.
 * @see SpannableStringBuilderScope
 * @see SpannableStringBuilder.append
 * @see DefaultSpannableStringBuilderScope
 * @return builder with added painted text.
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