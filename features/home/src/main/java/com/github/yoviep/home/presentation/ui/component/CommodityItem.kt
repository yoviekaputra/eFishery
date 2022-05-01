package com.github.yoviep.home.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yoviep.abstractions.extensions.orZero
import com.github.yoviep.abstractions.extensions.toFormatRp
import com.github.yoviep.home.R
import com.github.yoviep.home.domain.models.Commodity

/**
 * @created 01-05-2022 08:54
 * @author yoviekaputra
 * @project eFishery
 **/

@Composable
fun CommodityItem(
    modifier: Modifier = Modifier,
    commodity: Commodity
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.65f),
                    text = commodity.commodity ?: "-",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = commodity.price.toFormatRp(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.65f),
                    text = "${commodity.areaProvince.orEmpty()}: ${commodity.areaCity}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W200
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = stringResource(id = R.string.size, commodity.size.orZero()),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W200
                )
            }
        }
    )
}

@Preview
@Composable
fun CommodityItemPreview() {
    CommodityItem(
        commodity = Commodity(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    )
}