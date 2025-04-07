package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.window.Dialog
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true,
    name = "My Preview")
@Composable
fun AffirmationsPreview() {
    AffirmationsApp()
}

@Composable
fun AffirmationsApp() {
    val affirmationList = Datasource().loadAffirmations()

    LazyColumn() {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable {
                Toast.makeText(
                    context,
                    context.getString(affirmation.stringResourceId),
                    Toast.LENGTH_SHORT
                ).show()
                showDialog = true
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        AffirmationCardContents(
            affirmation = affirmation,
            horizontalAlignment = Alignment.Start,
            textStyle = MaterialTheme.typography.headlineSmall
        )
        if (showDialog) {
            AffirmationDialog(
                affirmation = affirmation,
                onDismiss = { showDialog = false }
            )
        }
    }
}

@Composable
fun AffirmationCardContents(
    affirmation: Affirmation,
    horizontalAlignment: Alignment.Horizontal,
    textStyle: TextStyle
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = horizontalAlignment
    ) {
        Image(
            painter = painterResource(affirmation.imageResourceId),
            contentDescription = stringResource(affirmation.stringResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = LocalContext.current.getString(affirmation.stringResourceId),
            modifier = Modifier.padding(16.dp),
            style = textStyle
        )
    }
}

@Composable
fun AffirmationDialog(
    affirmation: Affirmation,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .clickable(onClick = onDismiss)
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceDim
            ) {
                AffirmationCardContents(
                    affirmation = affirmation,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    textStyle = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}