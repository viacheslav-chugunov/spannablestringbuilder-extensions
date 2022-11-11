package viacheslav.chugunov.spannablestringbuilder.extensions

import android.content.Context
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope

class TestSpannableStringBuilderScope(
    private val origin: SpannableStringBuilderScope
) : SpannableStringBuilderScope {
    var builtLine: String = ""
        private set

    override fun bold(provideText: () -> CharSequence): CharSequence =
        origin.bold(provideText).record()

    override fun italic(provideText: () -> CharSequence): CharSequence =
        origin.italic(provideText).record()

    override fun underline(provideText: () -> CharSequence): CharSequence =
        origin.underline(provideText).record()

    override fun colorHex(colorHex: String, provideText: () -> CharSequence): CharSequence =
        origin.colorHex(colorHex, provideText).record()

    override fun colorInt(colorInt: Int, provideText: () -> CharSequence): CharSequence =
        origin.colorInt(colorInt, provideText).record()

    override fun colorRes(context: Context, colorRes: Int, provideText: () -> CharSequence): CharSequence =
        origin.colorRes(context, colorRes, provideText).record()

    override fun html(startTag: String, endTag: String, provideText: () -> CharSequence): CharSequence =
        origin.html(startTag, endTag, provideText).record()

    private fun CharSequence.record(): CharSequence = also { builtLine = it.toString() }
}