package viacheslav.chugunov.spannablestringbuilder.util

import android.content.Context
import android.content.res.Resources.NotFoundException
import android.graphics.Color
import androidx.core.content.ContextCompat

internal class SpannableStringBuilderScopeValidation {

    @Throws(IllegalColorHexException::class)
    fun checkColorHex(colorHex: String) {
        if (colorHex.length != 7)
            throw IllegalColorHexException(colorHex)
        try {
            Color.parseColor(colorHex)
        } catch (e: IllegalArgumentException) {
            throw IllegalColorHexException(colorHex)
        }
    }

    @Throws(NotFoundException::class)
    fun checkColorRes(context: Context, colorRes: Int) {
        try {
            ContextCompat.getColor(context, colorRes)
        } catch (e: NotFoundException) {
            throw e
        }
    }

    @Throws(IllegalHtmlTagsException::class)
    fun checkHtmlTags(startTag: String, endTag: String) {
        if (startTag.isBlank() || endTag.isBlank())
            throw IllegalHtmlTagsException(startTag, endTag)
        if (startTag.filter { it == '<' }.length != 1 || startTag.filter { it == '>' }.length != 1)
            throw IllegalHtmlTagsException(startTag, endTag)
        if (endTag.filter { it == '<' }.length != 1 || endTag.filter { it == '>' }.length != 1)
            throw IllegalHtmlTagsException(startTag, endTag)
        if (startTag.contains('/') || !endTag.contains('/'))
            throw IllegalHtmlTagsException(startTag, endTag)
    }

}