package viacheslav.chugunov.example

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import viacheslav.chugunov.spannablestringbuilder.example.R
import viacheslav.chugunov.spannablestringbuilder.extensions.append
import viacheslav.chugunov.spannablestringbuilder.example.databinding.ActivityMainBinding
import viacheslav.chugunov.spannablestringbuilder.extensions.appendBold
import viacheslav.chugunov.spannablestringbuilder.extensions.appendHtml
import viacheslav.chugunov.spannablestringbuilder.extensions.newLine

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spannableText = SpannableStringBuilder()
            .append { "Simple" }
            .newLine().newLine()
            .appendBold("Bold")
            .newLine().newLine()
            .append { bold { underline { "Bold Underline" } } }
            .newLine().newLine()
            .append { italic { colorRes(this@MainActivity, R.color.red) { "Red Italic" } } }
            .newLine().newLine()
            .appendHtml("<h1>", "Header", "</h1>")
        binding.exampleText.text = spannableText
    }
}