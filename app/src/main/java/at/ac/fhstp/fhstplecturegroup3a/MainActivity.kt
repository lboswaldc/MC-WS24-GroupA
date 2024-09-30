package at.ac.fhstp.fhstplecturegroup3a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import at.ac.fhstp.fhstplecturegroup3a.ui.theme.FHSTPLectureGroup3ATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FHSTPLectureGroup3ATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Calculation()
                    }

                }
            }
        }
    }
}

fun updateText(changedText: String) {
    println(changedText)
}

@Preview(showBackground = true)
@Composable
fun Calculation() {
    var input1Text by remember { mutableStateOf("") }
    var input2Text by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(input1Text, { input1Text = it }, label = { Text("Number 1") })
        OutlinedTextField(input2Text, { input2Text = it }, label = { Text("Number 2") })
        Button(onClick = {
            /*
            OnClick is an event, we can do side effects here
             */
            val num1 = input1Text.toDoubleOrNull() ?: 0.0
            val num2 = input2Text.toDoubleOrNull() ?: 0.0
            val sum = num1 + num2
            resultText = "$sum"
        }) {
            Text("Calculate!")
        }
        Text(resultText)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(Modifier.background(colorResource(R.color.primary))) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = stringResource(R.string.greeting)
        )
        Box(
            Modifier
                .size(dimensionResource(R.dimen.smallSpacing))
                .background(Color.Green)
        )
        Image(painterResource(R.drawable.baseline_alarm_24), stringResource(R.string.alarm_clock))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FHSTPLectureGroup3ATheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise3() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                Modifier
                    .background(Color.Red)
                    .weight(0.2f)
                    .fillMaxSize()
            )
            Box(
                Modifier
                    .background(Color.White)
                    .weight(1f)
                    .fillMaxSize()
            )
        }
        Row(
            Modifier
                .weight(0.2f)
                .fillMaxWidth()
                .background(Color.Red)
        ) {

        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.White),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("TEXT", fontSize = 36.sp)
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Red)
        ) {

        }
    }
}