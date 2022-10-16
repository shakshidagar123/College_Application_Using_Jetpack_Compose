package com.example.collegeapplication.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.collegeapplication.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegeapplication.data.DataSource
import com.example.collegeapplication.ui.theme.CollegeApplicationTheme


data class Society (

    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId : Int,
    @StringRes val string2ResourceId: Int

)


@Composable
fun SocietyCard(society: Society,modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(10.dp), elevation = 10.dp,shape= RoundedCornerShape(15.dp))
    {
        Column( modifier = Modifier,
        ){
            Image(
                painter = painterResource(id = society.imageResourceId) ,
                contentDescription = stringResource(society.stringResourceId ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.Crop
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween ,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(modifier=Modifier.padding(vertical=5.dp,horizontal=5.dp)) {
                    Text(
                        text = stringResource(id = society.stringResourceId),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(id = society.string2ResourceId),
                        style= MaterialTheme.typography.body2
                    )
                }

            }
        }
    }
}


@Composable
fun TextField() {
    var text by remember {mutableStateOf(TextFieldValue(""))}
    return OutlinedTextField(
        value= text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")},
        onValueChange = {
            text =it
        },
        placeholder = { Text(text = "Societies..")},
        shape= RoundedCornerShape(25.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
}

@Composable
fun SocietyList(societyList : List<Society> , modifier: Modifier= Modifier) {
    LazyColumn() {

        items(societyList) { Society ->
            SocietyCard(Society)
        }
    }
}


@Composable
fun SocietyScreen() {

    CollegeApplicationTheme() {

        Scaffold(
            topBar = {
                TextField()
            },
            content = {

                SocietyList(societyList = DataSource().loadSociety())
            }
        )
    }
}

