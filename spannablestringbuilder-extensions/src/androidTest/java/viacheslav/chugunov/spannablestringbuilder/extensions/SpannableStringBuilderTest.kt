package viacheslav.chugunov.spannablestringbuilder.extensions

import android.content.res.Resources.NotFoundException
import android.text.SpannableStringBuilder
import androidx.core.content.ContextCompat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import viacheslav.chugunov.spannablestringbuilder.scope.DefaultSpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.scope.SpannableStringBuilderScope
import viacheslav.chugunov.spannablestringbuilder.util.IllegalColorHexException
import viacheslav.chugunov.spannablestringbuilder.util.IllegalHtmlTagsException

@RunWith(AndroidJUnit4::class)
class SpannableStringBuilderTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    private val newScope: TestSpannableStringBuilderScope
        get() = TestSpannableStringBuilderScope(DefaultSpannableStringBuilderScope())

    private val newBuilder: SpannableStringBuilder
        get() = SpannableStringBuilder()

    @Test
    fun appendSimpleText() {
        val expected = "Simple Text"
        val actual = newBuilder.append { expected }.toString()
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun appendBoldText() = testModifiedText(
        expected = "<b>Bold</b>",
        builder = { bold { "Bold" } }
    )

    @Test
    fun appendItalicText() = testModifiedText(
        expected = "<i>Italic</i>",
        builder = { italic { "Italic" } }
    )

    @Test
    fun appendUnderline() = testModifiedText(
        expected = "<u>Underline</u>",
        builder = { underline { "Underline" } }
    )

    @Test
    fun appendColorHex() = testModifiedText(
        expected = "<font color=\"#df2c14\">Red</font>",
        builder = { colorHex("#df2c14") { "Red" } }
    )

    @Test(expected = IllegalColorHexException::class)
    fun appendInvalidColorHexFormat1() = testModifiedText(
        builder = { colorHex("df2c14") { "Illegal Hex Color 1" } }
    )

    @Test(expected = IllegalColorHexException::class)
    fun appendInvalidColorHexFormat2() = testModifiedText(
        builder = { colorHex("#ffdf2c14") { "Illegal Hex Color 2" } }
    )

    @Test(expected = IllegalColorHexException::class)
    fun appendInvalidColorHexFormat3() = testModifiedText(
        builder = { colorHex("#gggggg") { "Illegal Hex Color 3" } }
    )

    @Test
    fun appendColorInt() = testModifiedText(
        expected = "<font color=\"#000000\">Black</font>",
        builder = { colorInt(ContextCompat.getColor(context, android.R.color.black)) { "Black" } }
    )

    @Test
    fun appendColorRes() = testModifiedText(
        expected = "<font color=\"#000000\">Black</font>",
        builder = { colorRes(context, android.R.color.black) { "Black" } }
    )

    @Test(expected = NotFoundException::class)
    fun appendInvalidColorRes() = testModifiedText(
        expected = "",
        builder = { colorRes(context, 0) { "Black" } }
    )

    @Test
    fun appendHtml() = testModifiedText(
        expected = "<p>Paragraph</p>",
        builder = { html("<p>", "</p>") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat1() = testModifiedText(
        builder = { html("<", "</p>") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat2() = testModifiedText(
        builder = { html("<p>", "<") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat3() = testModifiedText(
        builder = { html("<p>", "<p>") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat4() = testModifiedText(
        builder = { html("<p>", ">") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat5() = testModifiedText(
        builder = { html("", "</p>") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat6() = testModifiedText(
        builder = { html("<p>", "") { "Paragraph" } }
    )

    @Test(expected = IllegalHtmlTagsException::class)
    fun appendInvalidHtmlFormat7() = testModifiedText(
        builder = { html("</p>", "<p>") { "Paragraph" } }
    )

    private fun testModifiedText(expected: String = "", builder: SpannableStringBuilderScope.() -> CharSequence) {
        val scope = newScope
        newBuilder.append(scope, builder)
        val actual = scope.builtLine
        Assert.assertEquals(expected, actual)
    }
}