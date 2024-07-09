package com.example.quotes_app.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.quotes_app.DataManager
import com.example.quotes_app.Models.Quote
import com.example.quotes_app.R

@Composable
fun QuoteDetails(quote: Quote) {
    BackHandler {
        DataManager.backToList()
        // Handle back navigation if needed
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFF000000),
                        Color(0xFFF2E9E4)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .align(Alignment.Start)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.quotation_mark),
                    contentDescription ="Quote",
                    modifier = Modifier
                        .size(80.dp)
                        //.rotate(180f)
                )
                Text(text = quote.text,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = quote.author,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    style = MaterialTheme.typography.bodyLarge,)
            }
        }
    }
}
