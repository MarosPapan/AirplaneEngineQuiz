package com.example.skuska2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skuska2.ui.theme.md_theme_dark_onPrimary
import com.example.skuska2.ui.theme.md_theme_light_surface

@Composable
fun AnswerButton(
    colorOFButton: Color,
    answerText: String,
    numberOfAnswer: Int,
    modifier: Modifier = Modifier,
    onClickFunction: () -> Unit
) {
    Button(
        onClick = onClickFunction,
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 6.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorOFButton
        ),
        border = BorderStroke(2.dp, md_theme_light_surface)
    ) {
        Text(
            text = numberOfAnswer.toString() + " option: "  + answerText,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun AnswerButtonPreview(){
    AnswerButton(colorOFButton = md_theme_dark_onPrimary, answerText = "Question that will be displayed", numberOfAnswer = 1, onClickFunction = {})
}