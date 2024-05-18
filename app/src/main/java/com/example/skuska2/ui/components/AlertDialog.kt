package com.example.skuska2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_surface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(
    onDismiss: () -> Unit,
    message: String,
    buttonText: String
){
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier.padding(5.dp),
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            tonalElevation = AlertDialogDefaults.TonalElevation,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.labelLarge
                    )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = onDismiss,
                        modifier = Modifier.wrapContentSize().padding(top = 20.dp),
                        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = md_theme_light_onPrimaryContainer
                        ),
                        border = BorderStroke(2.dp, md_theme_light_surface)
                    ) {
                        Text(
                            text = buttonText,
                            color = Color.White
                        )
                    }
                }
                }
        }
    }
}

@Preview
@Composable
fun AlertDialogPreview(){
    AlertDialog(onDismiss = { }, message = "You did not enter name", buttonText = "Fill the name")
}