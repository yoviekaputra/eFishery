package com.github.yoviep.home.presentation.ui.dialog.sorting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import com.github.yoviep.home.presentation.ui.component.TextCheckedItem


/**
 * @created 01-05-2022 23:54
 * @author yoviekaputra
 * @project eFishery
 **/

@Composable
fun SortDialog(
    onCheckedClick: (SortingUiModel) -> Unit,
    sorting: List<SortingUiModel>,
    checked: SortingUiModel?
) {
    Dialog(onDismissRequest = { }) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    color = Color.White
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .wrapContentHeight(),
                content = {
                    itemsIndexed(sorting) { position, item ->
                        TextCheckedItem(
                            text = item.text,
                            status = if (position == 0 && checked == null) {
                                true
                            } else {
                                item.key == checked?.key
                            },
                            onClick = {
                                onCheckedClick.invoke(item)
                            }
                        )

                        Divider()
                    }
                }
            )
        }
    }
}