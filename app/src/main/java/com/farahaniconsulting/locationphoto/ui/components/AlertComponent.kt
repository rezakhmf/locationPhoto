package com.farahaniconsulting.locationphoto.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.farahaniconsulting.locationphoto.R
import com.farahaniconsulting.locationphoto.ui.common.Dimes.XMedium
import com.farahaniconsulting.locationphoto.ui.common.Dimes.XxxMedium
import com.farahaniconsulting.locationphoto.ui.common.Dimes.XxxxMedium
import com.farahaniconsulting.locationphoto.ui.theme.AccentColor
import com.farahaniconsulting.locationphoto.ui.theme.RedError
import com.farahaniconsulting.locationphoto.ui.theme.TextWhite

@Composable
fun ShowLoading(
    modifier: Modifier
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(XxxxMedium)
                .align(Alignment.Center),
            color = AccentColor
        )
    }
}

@Composable
fun ShowError(
    error: String?,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = stringResource(id = R.string.error_icon_content),
                modifier = Modifier
                    .size(XxxMedium)
                    .padding(start = XMedium),
                tint = RedError
            )
            Text(
                text = error ?: stringResource(id = R.string.general_error_txt),
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}