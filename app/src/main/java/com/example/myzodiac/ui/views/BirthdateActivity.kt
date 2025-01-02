@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myzodiac.ui.views

import android.annotation.SuppressLint
import android.text.Selection.setSelection
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myzodiac.ui.theme.InterFontFamily
import com.example.myzodiac.ui.theme.customTextBoxColor
import com.example.myzodiac.viewmodel.ZodiacViewModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

//val InterFont = FontFamily(
//    Font(R.font.inter_regular, FontWeight.Normal),
//    Font(R.font.inter_bold, FontWeight.Bold)
//)

//Birthdate Activity.kt

//this is the second screen(view).
//it has a UI Card which has some text as DD-MM-YYYY on it? clicking on that placeholder text
//should open a datepicker and selected data should go back into text placeholder
//clicking on next button should show the result according to date input

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("NewApi")
@Composable
fun BirthdateScreen(
    viewModel: ZodiacViewModel,
    onNextClick: () -> Unit
) {
    var showErrorDialog by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val dateFormatter = remember { DateTimeFormatter.ofPattern("dd-MM-yyyy") }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.onBackground) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Select your Birthdate",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White, fontFamily = InterFontFamily),
                        modifier = Modifier.padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = selectedDate?.format(dateFormatter) ?: "DD-MM-YYYY",
                        style = TextStyle(fontSize = 16.sp, color = Color.Gray),
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { showDatePicker = true }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    if (showErrorDialog) {
                        AlertDialog(
                            onDismissRequest = { showErrorDialog = false },
                            title = {
                                Text(text = "Date Not Selected", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                            },
                            text = {
                                Text(text = "Please select a date before proceeding to the next step.")
                            },
                            confirmButton = {
                                TextButton(onClick = { showErrorDialog = false }) {
                                    Text("OK", color = Color.Blue)
                                }
                            }
                        )
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = customTextBoxColor,
                            disabledContainerColor = Color.LightGray
                        ),
                        onClick = {
                            if(selectedDate == null) {
                                showErrorDialog = true;
                            }
                            else {
                                selectedDate.let {
                                    if (it != null) {
                                        viewModel.calculateZodiacSign(it)
                                    }
                                    onNextClick()
                                }
                            }

                        },
                        enabled = selectedDate != null,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Next", color = Color.Black, fontFamily = InterFontFamily)
                    }
                }
            }

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = { showDatePicker = false }) {
                            Text("OK")
                        }
                    }
                ) {
                    val datePickerState = rememberDatePickerState(
                        initialSelectedDateMillis = selectedDate?.atStartOfDay(ZoneId.systemDefault())
                            ?.toInstant()
                            ?.toEpochMilli()
                    )

                    DatePicker(state = datePickerState)

                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            selectedDate = Instant.ofEpochMilli(millis)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                            showDatePicker = false
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true, backgroundColor = 0xFF131212)
//@Composable
//fun PreviewBirthdateScreen() {
//    BirthdateScreen(
//        viewMode,
//        onNextClick = { selectedDate ->
//            // Handle the next click, for preview just print the date
//            println("Selected Date: $selectedDate")
//        }
//    )
//}