package com.example.calculadora

import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme
import  androidx.compose.runtime.getValue
import  androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatoraScreen()


        }
    }
}
@Composable
fun CalculatoraScreen () {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Digite um valor") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Digite um valor ") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)
        ) {
            Button(onClick = { operator = "+" }, modifier = Modifier.padding(5.dp)) {
                Text("+")
            }
            Button(onClick = { operator = "-" }, modifier = Modifier.padding(5.dp)) {
                Text("-")
            }
            Button(onClick = { operator = "*" }, modifier = Modifier.padding(5.dp)) {
                Text("*")
            }
            Button(onClick = { operator = "/" }, modifier = Modifier.padding(5.dp)) {
                Text("/")

            }
            Button(modifier = Modifier.padding(5.dp), onClick = {
                if (value1.isNotEmpty() && value2.isNotEmpty() && operator.isNotEmpty()) {
                    result = when (operator) {
                        "+" -> (value1.toDouble() + value2.toDouble()).toString()
                        "-" -> (value1.toDouble() - value2.toDouble()).toString()
                        "*" -> (value1.toDouble() * value2.toDouble()).toString()
                        "/" -> (value1.toDouble() / value2.toDouble()).toString()

                        else -> ""


                    }


                }


            }) {
                Text("=")
            }
        }


        Button(modifier = Modifier.padding(7.dp), onClick = {
            value1 = ""
            value2 = ""
            operator = ""
            result = ""

        }) {
            Text("Limpar")
        }
        Button(onClick = { operator }, modifier = Modifier.align(CenterHorizontally)) {
            Text(" Operador usado é : $operator")
        }

        Button(onClick = { operator }, modifier = Modifier.align(CenterHorizontally)) {
            Text(" $result ")


            if (result.isNotEmpty()) {
                Text(
                    "Resultado : $value1 $operator $value2 = $result ",
                    Modifier.padding(vertical = 16.dp)
                )

            }
        }


    }
}
@Preview (showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatoraScreen()

}

