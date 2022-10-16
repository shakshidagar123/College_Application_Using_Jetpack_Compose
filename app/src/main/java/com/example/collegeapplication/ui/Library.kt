package com.example.collegeapplication.ui

import android.os.Bundle
import android.provider.CalendarContract.Events
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeapplication.R

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun LibraryScreen() {
        val pagerState = rememberPagerState(initialPage = 0)
        Column {
            Surface(color = MaterialTheme.colors.primary) {
                Column {
                    TabSection1(pagerState)
                }
            }
            pager(pagerState)
        }
    }





@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabSection1(pagerState: PagerState) {
        val tablist = listOf("About", "Rules")
        val coroutineScope = rememberCoroutineScope()

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            contentColor = MaterialTheme.colors.background,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[pagerState.currentPage]),
                    color = MaterialTheme.colors.primary
                )

            }
        ) {
            tablist.forEachIndexed { index, string ->
                Tab(selected = pagerState.currentPage == index,
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
    fun pager(pagerState: PagerState) {
        HorizontalPager(count = 2, state = pagerState) { page ->
            when (page) {
                0 -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val scrollState = rememberScrollState()
                        Column(modifier = Modifier.verticalScroll(scrollState)) {

                            val image = painterResource(id = R.drawable.lib1)
                            Image(
                                painter = image,
                                contentDescription = "",
                                modifier = Modifier.clip(RoundedCornerShape(20.dp)).padding(20.dp)
                            )

                            Text(
                                text = stringResource(R.string.about_lib),
                                modifier = Modifier.padding(start = 17.dp),
                                fontSize = 17.sp
                            )
                        }
                    }
                }
                1 -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val scrollState = rememberScrollState()
                        Column(modifier = Modifier.verticalScroll(scrollState))
                        {

                            Text(
                                text = "1.Timings of opening - 8:30 to 4:30 \nMonday to Friday",
                                modifier = Modifier.padding(20.dp),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = stringResource(R.string.Rule2),
                                modifier = Modifier.padding(15.dp),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )


                            Text(
                                text = stringResource(R.string.Rule3),
                                modifier = Modifier.padding(15.dp),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )


                        }
                    }
                }
            }
        }
    }
