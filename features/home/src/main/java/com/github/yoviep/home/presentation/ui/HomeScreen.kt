package com.github.yoviep.home.presentation.ui

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    onSearchChanged: (String) -> Unit,
    onSearchClear: () -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(
                content = {
                    HomeTopBar()

                    SearchBar(
                        uiState = uiState,
                        onSearchChanged = onSearchChanged,
                        onSearchClear = onSearchClear
                    )

                    if (uiState.isLoading) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp),
                            color = colorPrimary
                        )
                    }
                }
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

                    FloatingOption(
                        modifier = Modifier.Companion
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 24.dp),
                        uiState = uiState,
                        onSortingClick = onSortingClick,
                        onFilterClick = onFilterClick,
                        onAddClick = onAddClick
                    )
                }
            )
        }
    )
}

@Composable
private fun FloatingOption(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onSortingClick: () -> Unit,
    onFilterClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(percent = 50),
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
                        color = Color.Gray
                    )

                    HomeFloatingButton(
                        icon = R.drawable.ic_baseline_filter_alt_24,
                        text = stringResource(id = R.string.filter),
                        active = uiState.filterByArea != null,
                        onClick = onFilterClick
                    )

                    Divider(
                        modifier = Modifier
                            .height(32.dp)
                            .width(1.dp),
                        color = Color.Gray
                    )

                    HomeFloatingButton(
                        icon = R.drawable.ic_baseline_add_24,
                        text = "",
                        active = true,
                        onClick = onAddClick
                    )
                }
            )
        }
    )
}

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = {
            Icon(
                painter = painterResource(com.github.yoviep.themes.R.mipmap.ic_launcher_foreground),
                contentDescription = "logo",
                tint = Color.White
            )
        },
        backgroundColor = colorPrimary
    )
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onSearchChanged: (String) -> Unit,
    onSearchClear: () -> Unit
) {
    val textInputService = LocalTextInputService.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.keyword.orEmpty(),
                onValueChange = onSearchChanged,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onSearchChanged.invoke(uiState.keyword.orEmpty())
                        textInputService?.hideSoftwareKeyboard()
                    }
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        tint = Color.Gray,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if (!uiState.keyword.isNullOrBlank()) {
                        IconButton(
                            onClick = onSearchClear,
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_close_24),
                                    tint = Color.Gray,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = colorPrimary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(percent = 50)
            )
        }
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
        onSearchChanged = {
        },
        onSearchClear = {

        },
        onAddClick = {
        }
    )
}