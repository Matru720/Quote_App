package com.example.quotes_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotes_app.Models.Quote
import com.example.quotes_app.R
import com.example.quotes_app.DataManager

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Quote App",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        listOf(
                            Color(0xFF000000),
                            Color(0xFFF2E9E4)
                        )
                    )
                )
                .padding(PaddingValues(top = 30.dp)),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily(Font(R.font.poppins_bold))
        )

        QuoteList(data = data, onClick)

        Button(
            onClick = { DataManager.resetQuotes() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Refresh Quotes")
        }
    }
}
