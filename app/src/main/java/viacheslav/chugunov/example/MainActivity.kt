package viacheslav.chugunov.example

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import viacheslav.chugunov.spannablestringbuilder.extensions.append
import viacheslav.chugunov.spannablestringbuilder.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val s = SpannableStringBuilder()
            .append {
                colorHex("#db4437") {
                    bold {
                        italic {
                            "Formatted Test"
                        }
                    }
                }
            }
            .append("\n")
            .append {
                "Text 123"
            }
            .append("\nSimple Test")
        binding.exampleText.text = s
    }
}