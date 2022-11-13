package viacheslav.chugunov.example

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
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
            .append("This is an example with ")
            .append { bold { "bold text" } }
            .append(" and ")
            .append { colorHex("#CC0000") { italic { "red italic" } } }
        binding.exampleText.text = spannableText
    }
}