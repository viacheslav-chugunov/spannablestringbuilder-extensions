package viacheslav.chugunov.spannablestringbuilder.scope

import android.content.Context
import android.content.res.Resources.NotFoundException
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import viacheslav.chugunov.spannablestringbuilder.util.IllegalColorHexException
import viacheslav.chugunov.spannablestringbuilder.util.IllegalHtmlTagsException

interface SpannableStringBuilderScope {
    fun bold(provideText: () -> CharSequence): CharSequence

    fun italic(provideText: () -> CharSequence): CharSequence

    fun underline(provideText: () -> CharSequence): CharSequence

    @Throws(IllegalColorHexException::class)
    fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence

    fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence

    @Throws(NotFoundException::class)
    fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence

    @Throws(IllegalHtmlTagsException::class)
    fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence
}