package com.example.myzodiac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myzodiac.ui.theme.MyZodiacTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import com.example.myzodiac.R
import com.example.myzodiac.navigation.ZodiacNavigation
import com.example.myzodiac.ui.theme.InterFontFamily

//Main Activity.kt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyZodiacTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ZodiacNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


//this is the entry screen, it just contains a logo, some text and an explore button.
//Refactor code so that clicking on explore button takes to Birthdate pickup screen.
@Composable
fun ZodiacScreen(onExploreClick: () -> Unit, modifier: Modifier) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.onBackground) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.zodiac__1_),
                    contentDescription = "Zodiac Symbol",
                    modifier = Modifier.size(400.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "My Zodiac",
                    style = TextStyle(
                        fontFamily = InterFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = onExploreClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFDDB994) // Light tan color
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 64.dp)
                ) {
                    Text(
                        text = "Explore",
                        color = Color.Black,
                        style = TextStyle(
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )

                    )

                }
            }
        }
    }
}



@Preview(showBackground = true, backgroundColor = 0xFF131212)
@Composable
fun ZodiacScreenPreview() {
    MaterialTheme {
        ZodiacScreen(onExploreClick = { /*Mock Action*/}, modifier = Modifier)
    }
}