package com.ratham.notify.ui.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ratham.notify.ui.theme.AlphaNearOpaque
import com.ratham.notify.ui.theme.Ocean10
import com.ratham.notify.ui.components.NotifyButton
import com.ratham.notify.ui.theme.NotifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInContent(navController: NavController){
    Column(
        modifier = Modifier
            .padding(top = 200.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .background(
                color = NotifyTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Sign In",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column {
            val maxLength = 18

            Text(
                text = "University ID number",
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                color = NotifyTheme.colors.textSecondary,
            )
            TextField(
                value = username,
                onValueChange = {
                    if (it.length <= maxLength) username = it
                },
                singleLine = true,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium,
                placeholder = {
                    Text(
                        text = "Enter Your university ID number",
                        color = NotifyTheme.colors.textSecondary,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null,
                        tint = NotifyTheme.colors.textSecondary,
                    )
                },
                trailingIcon = {
                    if (username.isNotEmpty()) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                username = ""
                            }
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = NotifyTheme.colors.uiFloated,
                    cursorColor = NotifyTheme.colors.textSecondary,
                    errorCursorColor = NotifyTheme.colors.textSecondary,
                    disabledLabelColor = NotifyTheme.colors.uiFloated,
                    focusedIndicatorColor = Color.Transparent,
                    errorTrailingIconColor =  NotifyTheme.colors.error,
                    errorIndicatorColor = NotifyTheme.colors.error,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTrailingIconColor = NotifyTheme.colors.textSecondary,
                    unfocusedTrailingIconColor = NotifyTheme.colors.textSecondary



                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(top = 10.dp)) {
            val maxLength = 13
            var passwordVisibility by remember { mutableStateOf(false) }

            Text(
                text = "Password",
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                color = NotifyTheme.colors.textSecondary,
            )
            TextField(
                value = password,
                onValueChange = {
                    if (it.length <= maxLength) password = it
                },
                singleLine = true,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium,
                placeholder = {
                    Text(
                        text = "Enter Your Password",
                        color = NotifyTheme.colors.textSecondary,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = NotifyTheme.colors.textSecondary,
                    )
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisibility)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff,
                                contentDescription = null,
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = NotifyTheme.colors.uiFloated,
                    cursorColor = NotifyTheme.colors.textSecondary,
                    errorCursorColor = NotifyTheme.colors.textSecondary,
                    disabledLabelColor = NotifyTheme.colors.uiFloated,
                    focusedIndicatorColor = Color.Transparent,
                    errorTrailingIconColor = NotifyTheme.colors.error,
                    errorIndicatorColor = NotifyTheme.colors.error,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTrailingIconColor = NotifyTheme.colors.textSecondary,
                            unfocusedTrailingIconColor = NotifyTheme.colors.textSecondary

                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Row(modifier = Modifier
            .align(Alignment.End)
        ){
            val openDialog = remember { mutableStateOf(false)}
            TextButton(
                modifier = Modifier
                    .padding(top = 2.dp),
                onClick = { openDialog.value = true }
            ) {
                Text(
                    text = "Forgot password?",
                    color = Ocean10,
                    maxLines = 1
                )
            }
            if (openDialog.value){
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    text = {
                        Text(
                            text = "Functionality not Available",
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                    confirmButton = {
                        TextButton(onClick = { openDialog.value = false }) {
                            Text(text = "CLOSE")
                        }
                    },
                    containerColor = NotifyTheme.colors.uiFloated,
                    textContentColor = NotifyTheme.colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        Column(modifier = Modifier.padding(24.dp)) {
            NotifyButton(
                onClick = {
                    if (validateLoginCredetials()){
                        navController.navigate("home/Home"){
                            launchSingleTop = true
                            restoreState = true
                            popUpTo("signin/SignIn") {
                                inclusive = true
                            }
                        }
                    }else{
                        Toast.makeText(context, "Invalid Credentials" , Toast.LENGTH_LONG).show()
                    }

                },
            ) {
                Text(
                    text = "Log In ",
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }


        }
    }
}

//Validate credentials return true if the account exists and credentials are correct
fun validateLoginCredetials() : Boolean{
    return true
}
