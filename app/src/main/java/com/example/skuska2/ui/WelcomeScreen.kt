package com.example.skuska2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.R
import com.example.skuska2.Screen
import com.example.skuska2.domain.model.Constants
import com.example.skuska2.ui.components.AlertDialog
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_primary
import com.example.skuska2.views.WelcomeView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController, modifier: Modifier){
    val viewModel = viewModel<WelcomeView>()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(md_theme_light_primary)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            modifier = Modifier
                .size(150.dp),
            painter = painterResource(R.drawable.propeller),
            contentDescription = "Propeller")
        Text(
            text = "AIRPLANE ENGINE QUIZ",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White

        )

        if (viewModel.openDialog) {
            AlertDialog(onDismiss = {viewModel.onDismissAlertDialog()}, message = "Text field is empty", buttonText = "Fill the name")
        }

        if (viewModel.nameAlreadyExistDialog) {
            AlertDialog(onDismiss = {viewModel.onDismisNameExist()}, message = "Name already exists. Choose different name", buttonText = "Different name")
        }

        TextField(
            value = viewModel.text,
            onValueChange = viewModel::setValue,
            label = { Text(text = "your name")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account icon")
            },
            colors = TextFieldDefaults.textFieldColors(

            ),
            singleLine = true
        )
        Button(onClick ={
            if(viewModel.text.isEmpty()){
                viewModel.onOpenAlertDialog()
            } else {
                if (!viewModel.nameAlreadyExist(viewModel.text)){
                    viewModel.addPerson()
                    navController.navigate(Screen.CategoriesScreen.route+"/"+viewModel.text)
                    Constants.setUsername(viewModel.text)
                }else {
                    viewModel.nameAlreadyExist(viewModel.text)
                }
            }

        },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
            ) {
            Image(
                painter = painterResource(R.drawable.play),
                contentDescription = "Play button",
                modifier = Modifier.size(50.dp)
            )
        }

        Button(
            onClick = { navController.navigate(Screen.UsersScreen.route+"/"+true) },
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = md_theme_light_onPrimaryContainer
            )
            ) {
            Text(
                text = "Sign in with existing user",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
        }

        Image(
            painter = painterResource(R.drawable.airplane),
            contentDescription = "Airplane",
            modifier = Modifier
                .size(115.dp)
                .padding(top = 0.dp)
        )
    }
}
@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(navController = rememberNavController(), modifier = Modifier)
}