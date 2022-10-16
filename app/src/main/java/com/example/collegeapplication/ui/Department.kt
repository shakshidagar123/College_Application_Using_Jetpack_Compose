package com.example.collegeapplication.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.collegeapplication.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeapplication.data.DataSource
import com.example.collegeapplication.ui.theme.CollegeApplicationTheme


data class Departments(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)







@Composable
fun DepartmentScreen() {
    CollegeApplicationTheme() {
        Scaffold(
            topBar = {
                TextFieldWithIcons()
            },
            content = {

                DepartmentList(departmentList = DataSource().loadDepartments() )
            }
        )
    }

}

@Composable
fun DepartmentList(departmentList: List<Departments>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(departmentList) { department ->
            DepartmentCard(department)

        }
    }
}

@Composable
fun DepartmentCard(department: Departments, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .padding(8.dp),


        elevation = 10.dp) {
        Column {

            Image(
                painter = painterResource(department.imageResourceId),
                contentDescription = stringResource(department.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(department.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}


@Composable
fun TextFieldWithIcons() {
    Column() {
        var text by remember {mutableStateOf(TextFieldValue(""))}
        return OutlinedTextField(
            value= text,
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon") },
            onValueChange = {
                text =it
            },
            placeholder = { Text(text = "Department Name")},
            shape= RoundedCornerShape(25.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}