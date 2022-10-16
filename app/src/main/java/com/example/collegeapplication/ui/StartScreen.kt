package com.example.collegeapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.collegeapplication.CollegeAppScreen
import com.example.collegeapplication.R
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController

){
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Image(
            painter = painterResource(R.drawable.miranda_house_seal),
            contentDescription = null,
            modifier = Modifier.width(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.College_name), style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.University), style = MaterialTheme.typography.h4,fontWeight= FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(CollegeAppScreen.About.name)
            },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.About))
        }
        Button(
            onClick = {navController.navigate(CollegeAppScreen.Department.name)},
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.Department))
        }
        Button(
            onClick = {navController.navigate(CollegeAppScreen.Society.name)},
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.Society))
        }
        Button(
            onClick = {navController.navigate(CollegeAppScreen.Residence.name)},
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.Residence))
        }
        Button(
            onClick = {navController.navigate(CollegeAppScreen.Library.name)},
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.lib))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPreview(){

}