package com.example.quadrants

import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrants.ui.theme.QuadrantsTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f))
            {
                Cards(
                    title = "Bahamas",
                    //description = stringResource(R.string.first_description),
                    image = painterResource(R.drawable.bahamas),
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Bangladesh",
                    //description = stringResource(R.string.second_description),
                    image = painterResource(R.drawable.bangladesh),
                    backgroundColor = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f),
                )
            }

            Row(Modifier.weight(1f))
            {
                Cards(
                    title = "Canada",
                    //description = stringResource(R.string.third_description),
                    image = painterResource(R.drawable.canada),
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Russia",
                    //description = stringResource(R.string.fourth_description),
                    image = painterResource(R.drawable.russia),
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f),
                )
            }
            Row(Modifier.weight(1f))
            {
                Cards(
                    title = "Canada",
                    //description = stringResource(R.string.third_description),
                    image = painterResource(R.drawable.malaysia),
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Russia",
                    //description = stringResource(R.string.fourth_description),
                    image = painterResource(R.drawable.switzerland),
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }

    else {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {

                Cards(
                    title = "Bahamas",
                    //description = stringResource(R.string.first_description),
                    image = painterResource(R.drawable.bahamas),
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Bangladesh",
                    //description = stringResource(R.string.second_description),
                    image = painterResource(R.drawable.bangladesh),
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f),
                )


                Cards(
                    title = "Canada",
                    //description = stringResource(R.string.third_description),
                    image = painterResource(R.drawable.canada),
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f),
                )
            }

            Row(Modifier.weight(1f)) {
                Cards(
                    title = "Russia",
                    //description = stringResource(R.string.fourth_description),
                    image = painterResource(R.drawable.russia),
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Canada",
                    //description = stringResource(R.string.third_description),
                    image = painterResource(R.drawable.malaysia),
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f),
                )

                Cards(
                    title = "Russia",
                    //description = stringResource(R.string.fourth_description),
                    image = painterResource(R.drawable.switzerland),
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantsTheme {
        MainPage()
    }
}

@Composable
public fun Cards(
    title: String,
    image: Painter,
    //description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .height(80.dp),

        )
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
//        Text(
//            text = description,
//            textAlign = TextAlign.Justify
//        )

    }
}