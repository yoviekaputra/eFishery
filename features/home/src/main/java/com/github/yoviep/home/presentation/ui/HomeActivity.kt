package com.github.yoviep.home.presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.github.yoviep.home.presentation.models.HomeEventState
import com.github.yoviep.home.presentation.ui.dialog.sorting.SortDialog
import com.github.yoviep.home.presentation.ui.dialog.sorting.SortingUiModel
import com.github.yoviep.home.presentation.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCommodity()

        setContent {
            val uiState = viewModel.uiState.collectAsState()

            HomeScreen(
                uiState = uiState.value,
                onSortingClick = {
                    viewModel.onEventState(HomeEventState.OnSortingClick)
                },
                onFilterClick = {
                },
                onSearchClick = {
                },
                onAddClick = {
                }
            )

            if (uiState.value.showSortDialog) {
                SortDialog(
                    onCheckedClick = {
                        viewModel.onEventState(HomeEventState.OnSortingClicked(it))
                    },
                    sorting = SortingUiModel.getSortingList(this),
                    checked = uiState.value.sortBy
                )
            }
        }
    }
}