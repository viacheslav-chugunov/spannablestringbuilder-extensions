package viacheslav.chugunov.example

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import viacheslav.chugunov.spannablestringbuilder.example.R
import viacheslav.chugunov.spannablestringbuilder.extensions.append
import viacheslav.chugunov.spannablestringbuilder.example.databinding.ActivityMainBinding
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
            .append { bold { "Bold" } }
            .newLine().newLine()
            .append { bold { underline { "Bold Underline" } } }
            .newLine().newLine()
            .append { italic { colorRes(this@MainActivity, R.color.red) { "Red Italic" } } }
            .newLine().newLine()
            .append { html("<h1>", "</h1>") { "Header" } }
        binding.exampleText.text = spannableText
    }
}