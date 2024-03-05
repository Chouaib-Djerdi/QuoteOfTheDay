package com.example.quoteoftheday

import Card
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteoftheday.ui.theme.Background
import com.example.quoteoftheday.ui.theme.CardColor
import com.example.quoteoftheday.ui.theme.QuoteOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteOfTheDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Background
                ) {
                    MainContent(modifier = Modifier)
                }
            }
        }
    }
}

data class Quote (
    val quote : String,
    val author : String
)
val quotes = arrayOf(
    Quote(
        quote = "The journey of a thousand miles begins with a single step.",
        author = "Lao Tzu"
    ),
    Quote(
        quote = "The mind is everything. What you think you become.",
        author = "Buddha"
    ),
    // Add more quotes as needed
)


@Composable
fun MainContent(modifier:Modifier) {
    var currentQuote : Quote by remember { mutableStateOf(quotes[0]) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 32.dp,
                end = 32.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(
            text = "Quote Of The Day",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Card(currentQuote,modifier=Modifier)
        Button(
            onClick = {

                currentQuote = quotes.random()
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = CardColor,
            )
            ) {
            Text(text = "Generate Quote")

        }
    }
}