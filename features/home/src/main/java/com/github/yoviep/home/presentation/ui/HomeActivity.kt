package com.github.yoviep.home.presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.github.yoviep.home.presentation.models.HomeEventState
import com.github.yoviep.home.presentation.ui.dialog.create.CreateCommodityDialog
import com.github.yoviep.home.presentation.ui.dialog.filter.FilterDialog
import com.github.yoviep.home.presentation.ui.dialog.sorting.SortDialog
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
                    viewModel.onEventState(HomeEventState.OnFilterClick)
                },
                onSearchChanged = {
                    viewModel.onEventState(HomeEventState.OnSearchChanged(it))
                },
                onSearchClear = {
                    viewModel.onEventState(HomeEventState.OnSearchClear)
                },
                onAddClick = {
                    viewModel.onEventState(HomeEventState.OnAddClick)
                }
            )

            if (uiState.value.showSortDialog) {
                SortDialog(
                    onCheckedClick = {
                        viewModel.onEventState(HomeEventState.OnSortingClicked(it))
                    },
                    sorting = uiState.value.getSortingList(this),
                    checked = uiState.value.sortBy
                )
            }

            if (uiState.value.showFilterDialog) {
                FilterDialog(
                    onCheckedClick = {
                        viewModel.onEventState(HomeEventState.OnFilterClicked(it))
                    },
                    filtering = uiState.value.getAreas(),
                    checked = uiState.value.filterByArea
                )
            }

            if (uiState.value.showAddDialog) {
                CreateCommodityDialog(
                    commodity = uiState.value.newCommodity,
                    onChangeForm = {
                        viewModel.onEventState(HomeEventState.OnFormFieldChange(it))
                    },
                    onSubmit = {
                        viewModel.onEventState(HomeEventState.OnAddNewSubmit)
                    }
                )
            }
        }
    }
}