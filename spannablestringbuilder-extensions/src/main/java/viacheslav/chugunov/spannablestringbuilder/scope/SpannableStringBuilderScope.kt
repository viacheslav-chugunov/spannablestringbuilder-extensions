package viacheslav.chugunov.spannablestringbuilder.scope

import android.content.Context
import android.content.res.Resources.NotFoundException
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import viacheslav.chugunov.spannablestringbuilder.util.IllegalColorHexException
import viacheslav.chugunov.spannablestringbuilder.util.IllegalHtmlTagsException

/**
 * Scope in which you can modify the transmitted text or part of it.
 * */
interface SpannableStringBuilderScope {
    /**
     * Makes wrapped text bold.
     * @param provideText function that should return the text to wrap.
     * @return bold text.
     * */
    fun bold(provideText: () -> CharSequence): CharSequence

    /**
     * Makes wrapped text italic.
     * @param provideText function that should return the text to wrap.
     * @return italic text.
     * */
    fun italic(provideText: () -> CharSequence): CharSequence

    /**
     * Makes wrapped text underlined.
     * @param provideText function that should return the text to wrap.
     * @return underlined text.
     * */
    fun underline(provideText: () -> CharSequence): CharSequence

    /**
     * Paints the text in the selected color.
     * @param colorHex color in hex a format. Valid format is #FFFFFF.
     * @param provideText function that should return the text you want to paint.
     * @throws IllegalColorHexException if the text is in the wrong format.
     * @return painted text.
     * */
    @Throws(IllegalColorHexException::class)
    fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence

    /**
     * Paints the text in the selected color.
     * @param colorInt int value of the text.
     * @param provideText function that should return the text you want to paint.
     * @return painted text.
     * */
    fun colorInt(@ColorInt colorInt: Int, provideText: () -> CharSequence): CharSequence

    /**
     * Paints the text in the selected color.
     * @param context application context.
     * @param colorRes resource of the text.
     * @param provideText function that should return the text you want to paint.
     * @throws NotFoundException if the color resource is invalid.
     * @return painted text.
     * */
    @Throws(NotFoundException::class)
    fun colorRes(context: Context, @ColorRes colorRes: Int, provideText: () -> CharSequence): CharSequence

    /**
     * Wraps text in html tags.
     * @param startTag left html tag. Valid format is <h1>.
     * @param endTag right html tag. Valid format is </h1>.
     * @param provideText function that should return the text to wrap.
     * @throws IllegalHtmlTagsException if the tags are in the wrong format.
     * @return modified text.
     * */
    @Throws(IllegalHtmlTagsException::class)
    fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence
}