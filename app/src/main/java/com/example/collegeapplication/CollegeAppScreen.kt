package com.example.collegeapplication

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.collegeapplication.ui.*


/**
 * enum values that represent the screens in the app
 */

enum class CollegeAppScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    About(title = R.string.About),
    Department(title = R.string.Department),
    Society(title = R.string.Society),
    Residence(title = R.string.Residence),
    Library(title=R.string.Library)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */

@Composable
fun CollegeAppBar(
    currentScreen: CollegeAppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
@Composable
fun CollegeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = CollegeAppScreen.valueOf(
        backStackEntry?.destination?.route ?: CollegeAppScreen.Start.name
    )
    Scaffold(
        topBar = {
            CollegeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){
        NavHost(navController = navController, startDestination = CollegeAppScreen.Start.name){
            composable(route=CollegeAppScreen.Start.name){
                StartScreen(navController = navController)
            }
            composable(route=CollegeAppScreen.About.name){
                About()
            }
            composable(route=CollegeAppScreen.Department.name){
                DepartmentScreen()
            }
            composable(route=CollegeAppScreen.Society.name){
                SocietyScreen()
            }
            composable(route=CollegeAppScreen.Residence.name){
                ResidenceScreen()
            }
            composable(route=CollegeAppScreen.Library.name){
                LibraryScreen()
            }
        }
    }


}




