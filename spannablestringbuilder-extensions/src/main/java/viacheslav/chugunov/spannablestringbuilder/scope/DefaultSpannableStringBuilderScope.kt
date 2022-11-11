package viacheslav.chugunov.spannablestringbuilder.scope

import android.content.Context
import android.content.res.Resources
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import viacheslav.chugunov.spannablestringbuilder.util.IllegalColorHexException
import viacheslav.chugunov.spannablestringbuilder.util.IllegalHtmlTagsException
import viacheslav.chugunov.spannablestringbuilder.util.SpannableStringBuilderScopeValidation

class DefaultSpannableStringBuilderScope: SpannableStringBuilderScope {
    private val validation = SpannableStringBuilderScopeValidation()

    override fun bold(provideText: () -> CharSequence): CharSequence =
        html("<b>", "</b>", provideText)

    override fun italic(provideText: () -> CharSequence): CharSequence =
        html("<i>", "</i>", provideText)

    override fun underline(provideText: () -> CharSequence): CharSequence =
        html("<u>", "</u>", provideText)

    @Throws(IllegalColorHexException::class)
    override fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence {
        validation.checkColorHex(colorHex)
        return html("<font color=\"$colorHex\">", "</font>", provideText)
    }

    override fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence {
        val colorHex = String.format("#%06X", 0xFFFFFF and colorInt)
        return html("<font color=\"$colorHex\">", "</font>", provideText)
    }

    @Throws(Resources.NotFoundException::class)
    override fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence {
        validation.checkColorRes(context, colorRes)
        val colorInt = ContextCompat.getColor(context, colorRes)
        return colorInt(colorInt, provideText)
    }

    @Throws(IllegalHtmlTagsException::class)
    override fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence {
        validation.checkHtmlTags(startTag, endTag)
        return "$startTag${provideText()}$endTag"
    }
}