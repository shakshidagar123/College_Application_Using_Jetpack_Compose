package com.example.collegeapplication.ui

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.collegeapplication.R

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch



@OptIn(ExperimentalPagerApi::class)
@Composable
fun ResidenceScreen() {

    val pagerState = rememberPagerState(0)
    Column {
        Surface(color = MaterialTheme.colors.primary) {
            Column {

                TabSection(pagerState)
            }
        }
        Pager(pagerState)
    }
}



@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabSection(pagerState: PagerState) {
    val tablist = listOf("About", "Facilities")
    val  coroutineScope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = MaterialTheme.colors.background,
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(it[pagerState.currentPage]),
                color = MaterialTheme.colors.primary
            )
        }
    ){
        tablist.forEachIndexed { index, string ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(text = string.uppercase())
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager(pagerState: PagerState) {
    HorizontalPager(count = 2, state = pagerState) { page ->
        when(page) {
            0 -> {
                Box(modifier = Modifier.fillMaxWidth()) {
                    val scrollState = rememberScrollState()
                    Column(modifier = Modifier.verticalScroll(scrollState))
                    {
                        val image = painterResource(id = R.drawable.about)
                        androidx.compose.foundation.Image(painter = image, contentDescription = null,
                            modifier = Modifier.padding(start = 20.dp))
                        Text(
                            text = stringResource(R.string.about),
                            fontSize = 17.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                }
            }

            1 -> {
                Box(modifier = Modifier.fillMaxWidth()){
                    val scrollState = rememberScrollState()
                    Column(modifier = Modifier.verticalScroll(scrollState))
                    {
                        Row() {
                            val image = painterResource(id = R.drawable.rooms)
                            Image(
                                painter = image,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 20.dp)
                                    .width(150.dp)
                                    .height(120.dp)
                            )

                            val image1 = painterResource(id = R.drawable.mess)
                            Image(
                                painter = image1,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 20.dp)
                                    .width(150.dp)
                                    .height(120.dp)
                            )
                        }
                        val image2 = painterResource(id = R.drawable.corridors)
                        Image(
                            painter = image2,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 90.dp)
                                .width(200.dp)
                                .height(100.dp)
                        )
                        Text(text = stringResource(R.string.Accommodation),fontSize = 20.sp, textAlign = TextAlign.Center,modifier = Modifier.padding(top = 20.dp, start = 60.dp)

                        )
                        Text(text = stringResource(R.string.Rooms),fontSize = 15.sp, modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Washrooms),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Water),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Hall),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Launderette),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Reading_Room),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Sports),fontSize = 15.sp,modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Medical_Unit),fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp, start = 120.dp),
                            textAlign = TextAlign.Center)
                        Text(text = stringResource(R.string.Sickbay),fontSize = 15.sp, modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Medical),fontSize = 15.sp, modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Counseling),fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp, start = 120.dp),textAlign = TextAlign.Center)
                        Text(text = stringResource(R.string.Career),fontSize = 15.sp, modifier = Modifier.padding(top = 10.dp))
                        Text(text = stringResource(R.string.Psycho_Social),fontSize = 15.sp, modifier = Modifier.padding(top = 10.dp))
                    }
                }

            }
        }
    }

}