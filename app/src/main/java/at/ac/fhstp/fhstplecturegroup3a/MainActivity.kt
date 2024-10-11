package at.ac.fhstp.fhstplecturegroup3a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import at.ac.fhstp.fhstplecturegroup3a.ui.MainApp
import at.ac.fhstp.fhstplecturegroup3a.ui.theme.FHSTPLectureGroup3ATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPLectureGroup3ATheme {
                MainApp()
            }
        }
    }
}

fun updateText(changedText: String) {
    println(changedText)
}

