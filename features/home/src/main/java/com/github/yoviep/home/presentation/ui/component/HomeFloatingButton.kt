package com.github.yoviep.home.presentation.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yoviep.themes.colorPrimary


/**
 * @created 01-05-2022 23:48
 * @author yoviekaputra
 * @project eFishery
 **/


@Composable
fun HomeFloatingButton(
    @DrawableRes icon: Int,
    text: String,
    active: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 0.dp
        ),
        content = {
            Icon(
                painter = painterResource(id = icon),
                tint = if (active) {
                    colorPrimary
                } else {
                    Color.Gray
                },
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = if (active) {
                    colorPrimary
                } else {
                    Color.Gray
                }
            )
        },
        onClick = onClick
    )
}
