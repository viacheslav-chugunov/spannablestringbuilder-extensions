package viacheslav.chugunov.spannablestringbuilder_extensions

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import viacheslav.chugunov.spannablestringbuilder_extensions.databinding.ActivityMainBinding

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
//                color("#db4437") {
                    bold {
//                        italic {
                        "Formatted Test"
//                        }
                    }
//                }
            }
            .append("\nSimple Test")
        binding.exampleText.text = s
    }
}