package com.example.myzodiac.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import com.example.myzodiac.R
import com.example.myzodiac.model.ZodiacSign
import com.example.myzodiac.ui.theme.InterFontFamily
import com.example.myzodiac.ui.theme.customTextBoxColor
import com.example.myzodiac.ui.theme.slightBlack
import com.example.myzodiac.viewmodel.ZodiacViewModel
import kotlinx.coroutines.flow.MutableStateFlow


//val InterFont = FontFamily(
//    Font(R.font.inter_regular, FontWeight.Normal),
//    Font(R.font.inter_bold, FontWeight.Bold)
//)


//ResultActivity.kt


//this is the final details screen of the app.
//it contains the info about zodiac signs their logo, icon,  name etc.
// we will recieve info from our repository and fill it out in our UI as follows


@Composable
fun ZodiacDetailScreen(viewModel: ZodiacViewModel,
                       onCheckAnotherClick: () -> Unit) {
    val zodiacSign by viewModel.zodiacSign.collectAsState()
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.onBackground) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 16.dp)
                        .padding(top = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1A212B) // Dark gray card color
                    )
                ) {
                    //this will get the val imageResId: Int and fill it in r.drawable.{zodiacName}
                    Column(modifier = Modifier.padding(0.dp)) {
                        zodiacSign?.let { sign ->
                            Image(
                                painter = painterResource(id = sign.imageResId),
                                contentDescription = "Zodiac Image",
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.padding(horizontal = 32.dp)
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Your zodiac sign is.. ",
                        style = TextStyle(
                            fontFamily = InterFontFamily,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                zodiacSign?.let { sign ->
                    Row(
                        modifier = Modifier.padding(horizontal = 32.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        //this will get the val iconResId and fill it in r.drawable.{zodiacName}_icon
                        Icon(
                            painter = painterResource(id = sign.iconResId),
                            contentDescription = "Zodiac Icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        //this will get the val name and replace it
                        Text(
                            text = sign.name,
                            style = TextStyle(
                                fontFamily = InterFontFamily,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = sign.description,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontFamily = InterFontFamily

                            ),
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        textAlign = TextAlign.Justify
                    )
                    Text(
                        text = sign.history,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontFamily = InterFontFamily

                            ),
                        modifier = Modifier.fillMaxWidth()
                            .padding(32.dp),
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    //this button navigates back to datepick view
                    Button(
                        onClick = onCheckAnotherClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = customTextBoxColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp)
                            .padding(bottom = 48.dp)
                    ) {
                        Text(
                            text = "Check another Birthdate",
                            color = Color.Black,
                            fontFamily = InterFontFamily
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF131212)
@Composable
fun ZodiacDetailScreenPreview() {
    // Mock data for preview
    val mockZodiacSign = ZodiacSign("Aries",
        startDate = Pair(3, 21),
        endDate = Pair(4, 19),
        "Bold and Ambitious",
        "Insert aries history here",R.drawable.aries_icon, R.drawable.aries)


    val mockViewModel = object : ZodiacViewModel() {
        override val zodiacSign = MutableStateFlow(mockZodiacSign)
    }

    MaterialTheme {
        ZodiacDetailScreen(
            viewModel = mockViewModel,
            onCheckAnotherClick = { /* Mock action */ }
        )
    }
}
