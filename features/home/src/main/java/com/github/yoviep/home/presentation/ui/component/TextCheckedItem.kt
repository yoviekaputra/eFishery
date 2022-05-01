package com.github.yoviep.home.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yoviep.home.R
import com.github.yoviep.themes.colorPrimary


/**
 * @created 07/03/22 04.46
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun TextCheckedItem(
    onClick: () -> Unit,
    text: String,
    status: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                onClick.invoke()
            }.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = text,
            fontSize = 14.sp
        )

        if (status) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                contentDescription = null,
                tint = colorPrimary
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}