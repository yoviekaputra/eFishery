package com.github.yoviep.home.presentation.ui

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yoviep.home.R
import com.github.yoviep.home.presentation.models.HomeUiState
import com.github.yoviep.home.presentation.ui.component.CommodityItem
import com.github.yoviep.home.presentation.ui.component.HomeFloatingButton
import com.github.yoviep.themes.colorPrimary


/**
 * @created 01-05-2022 06:21
 * @author yoviekaputra
 * @project eFishery
 **/

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onSortingClick: () -> Unit,
    onFilterClick: () -> Unit,
    onSearchClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClick = onSearchClick
            )
        },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                content = {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            items(
                                items = uiState.items,
                                itemContent = { item ->
                                    CommodityItem(
                                        commodity = item
                                    )

                                    Divider(
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                                }
                            )
                        }
                    )

                    Card(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 24.dp),
                        elevation = 4.dp,
                        shape = RoundedCornerShape(20.dp),
                        content = {
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .wrapContentWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                content = {

                                    HomeFloatingButton(
                                        icon = R.drawable.ic_baseline_sort_24,
                                        text = stringResource(id = R.string.sorting),
                                        active = uiState.sortBy != null,
                                        onClick = onSortingClick
                                    )

                                    Divider(
                                        modifier = Modifier
                                            .height(32.dp)
                                            .width(1.dp),
                                        color = colorPrimary
                                    )

                                    HomeFloatingButton(
                                        icon = R.drawable.ic_baseline_filter_alt_24,
                                        text = stringResource(id = R.string.filter),
                                        active = uiState.filterByArea != null,
                                        onClick = onFilterClick
                                    )
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}

@Composable
fun HomeTopBar(
    onSearchClick: () -> Unit
) {
    TopAppBar(
        title = {
            Icon(
                painter = painterResource(com.github.yoviep.themes.R.mipmap.ic_launcher_foreground),
                contentDescription = "logo",
                tint = Color.White
            )
        },
        actions = {
            IconButton(
                onClick = onSearchClick,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            )
        },
        backgroundColor = colorPrimary
    )
}

@Preview(
    uiMode = UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        uiState = HomeUiState(),
        onSortingClick = {
        },
        onFilterClick = {
        },
        onSearchClick = {
        },
        onAddClick = {
        }
    )
}