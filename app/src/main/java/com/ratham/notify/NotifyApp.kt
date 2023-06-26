package com.ratham.notify

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController

import com.google.accompanist.insets.ProvideWindowInsets
import com.ratham.notify.ui.components.NotifyScaffold
import com.ratham.notify.ui.theme.NotifyTheme


@Composable
fun NotifyApp() {
    ProvideWindowInsets {
        NotifyTheme {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            NotifyScaffold(
                scaffoldState = scaffoldState,
            ){
                NotifyNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}