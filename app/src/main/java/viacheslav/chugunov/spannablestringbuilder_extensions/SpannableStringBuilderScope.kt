package viacheslav.chugunov.spannablestringbuilder_extensions

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

interface SpannableStringBuilderScope {
    fun bold(provideText: () -> CharSequence): CharSequence
    fun italic(provideText: () -> CharSequence): CharSequence
    fun underline(provideText: () -> CharSequence): CharSequence
    fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence
    fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence
    fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence
    fun html(provideText: () -> CharSequence, startTag: String, endTag: String): CharSequence


    @Suppress("OVERRIDE_BY_INLINE")
    class Default: SpannableStringBuilderScope {

        override inline fun bold(provideText: () -> CharSequence): CharSequence =
            html(provideText, "<b>", "</b>")

        override inline fun italic(provideText: () -> CharSequence): CharSequence =
            html(provideText, "<i>", "</i>")

        override inline fun underline(provideText: () -> CharSequence): CharSequence =
            html(provideText, "<u>", "</u>")

        override inline fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence =
            html(provideText, "<font color=\"$colorHex\">", "</font>")

        override inline fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence {
            val colorHex = String.format("#%06X", 0xFFFFFF and colorInt)
            return html(provideText, "<font color=\"$colorHex\">", "</font>")
        }

        override inline fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence {
            val colorInt = ContextCompat.getColor(context, colorRes)
            return colorInt(colorInt, provideText)
        }

        override inline fun html(provideText: () -> CharSequence, startTag: String, endTag: String): CharSequence =
            "$startTag${provideText()}$endTag"
    }
}