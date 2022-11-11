package viacheslav.chugunov.spannablestringbuilder.extensions

import android.content.Context
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope

class TestSpannableStringBuilderScope(
    private val origin: SpannableStringBuilderScope
) : SpannableStringBuilderScope {
    var builtLine: String = ""
        private set

    override fun bold(provideText: () -> CharSequence): CharSequence =
        origin.bold(provideText).also { builtLine += it }

    override fun italic(provideText: () -> CharSequence): CharSequence =
        origin.italic(provideText).also { builtLine += it }

    override fun underline(provideText: () -> CharSequence): CharSequence =
        origin.underline(provideText).also { builtLine += it }

    override fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence =
        origin.colorHex(colorHex, provideText).also { builtLine += it }

    override fun colorInt(colorInt: Int, provideText: () -> CharSequence): CharSequence =
        origin.colorInt(colorInt, provideText).also { builtLine += it }

    override fun colorRes(context: Context, colorRes: Int, provideText: () -> CharSequence): CharSequence =
        origin.colorRes(context, colorRes, provideText).also { builtLine += it }

    override fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence =
        origin.html(startTag, endTag, provideText).also { builtLine += it }
}