package com.github.yoviep.home.presentation.ui.dialog.create

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.github.yoviep.home.R
import com.github.yoviep.home.domain.models.Commodity
import com.github.yoviep.themes.colorPrimary


/**
 * @created 02-05-2022 07:14
 * @author yoviekaputra
 * @project eFishery
 **/

@Composable
fun CreateCommodityDialog(
    commodity: Commodity,
    isLoading: Boolean,
    onChangeForm: (Commodity) -> Unit,
    onSubmit: () -> Unit
) {

    Dialog(onDismissRequest = { }) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    color = Color.White
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextFieldCommodity(
                text = commodity.areaCity.orEmpty(),
                placeholderId = R.string.city,
                onValueChange = {
                    onChangeForm.invoke(commodity.copy(areaCity = it))
                }
            )

            TextFieldCommodity(
                text = commodity.areaProvince.orEmpty(),
                placeholderId = R.string.province,
                onValueChange = {
                    onChangeForm.invoke(commodity.copy(areaProvince = it))
                }
            )

            TextFieldCommodity(
                text = commodity.commodity.orEmpty(),
                placeholderId = R.string.commodity,
                onValueChange = {
                    onChangeForm.invoke(commodity.copy(commodity = it))
                }
            )

            TextFieldCommodity(
                text = commodity.price.orEmpty(),
                placeholderId = R.string.price,
                onValueChange = {
                    onChangeForm.invoke(commodity.copy(price = it))
                },
                keyboardType = KeyboardType.Number
            )

            TextFieldCommodity(
                text = commodity.size.orEmpty(),
                placeholderId = R.string.size_input,
                onValueChange = {
                    onChangeForm.invoke(commodity.copy(size = it))
                },
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )

            Button(
                onClick = {
                    onSubmit.invoke()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorPrimary,
                    contentColor = Color.White
                ),
                enabled = !isLoading,
                content = {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.CenterVertically),
                            color = Color.White
                        )
                    } else {
                        Text(
                            text = "Simpan",
                            fontSize = 14.sp
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun TextFieldCommodity(
    @StringRes placeholderId: Int,
    text: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    imeAction: ImeAction = ImeAction.Next,
    focusRequester: FocusManager = LocalFocusManager.current,
    textInputService: TextInputService? = LocalTextInputService.current
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = text,
        placeholder = {
            Text(
                text = stringResource(id = placeholderId),
                fontSize = 14.sp
            )
        },
        onValueChange = {
            onValueChange.invoke(it)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusRequester.moveFocus(FocusDirection.Next)
            },
            onDone = {
                textInputService?.hideSoftwareKeyboard()
            }
        ),
        //keyboardType = keyboardType,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = colorPrimary,
            focusedIndicatorColor = colorPrimary,
            unfocusedIndicatorColor = Color.Gray
        )
    )
}