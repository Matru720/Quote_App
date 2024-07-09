package com.example.quotes_app.Screens

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    }
    val context = LocalContext.current

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
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(32.dp)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .align(Alignment.Start)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp, 24.dp)
                ) {
                    Image(
                        imageVector = Icons.Outlined.FormatQuote,
                        contentDescription = "Quote",
                        modifier = Modifier
                            .size(80.dp)
                            .rotate(180f)
                    )
                    Text(
                        text = quote.text,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = quote.author,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val shareIntent = Intent.createChooser(Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "\"${quote.text}\" - ${quote.author}")
                        type = "text/plain"
                    }, null)
                    context.startActivity(shareIntent)
                },
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = ""
                )
            }
        }
    }
}
