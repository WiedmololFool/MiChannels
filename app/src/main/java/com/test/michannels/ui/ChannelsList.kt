package com.test.michannels.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.michannels.model.Channel
import com.test.michannels.ui.theme.MiChannelsTheme

@Composable
fun ChannelsList(
    loading: Boolean,
    channels: List<Channel>,
    onChangeScrollPosition: (Int) -> Unit,
    onChannelClick: (Int, Channel) -> Unit
) {
    Box(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
        if (loading && channels.isEmpty()) {
            CircularProgressIndicator()
        } else if (channels.isEmpty()) {
            Text("Nothing here")
        } else {
            LazyColumn {
                itemsIndexed(items = channels) { index, channel ->
                    onChangeScrollPosition(index)
                    ChannelCard(
                        index = index,
                        channel = channel,
                        onClick = { onChannelClick(index, channel) }
                    )
                }
            }
        }
    }

}

@Composable
fun ChannelCard(
    index: Int,
    channel: Channel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small,
    ) {
        Row() {
            Text(text = index.toString(), style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Text(text = channel.name, style = MaterialTheme.typography.body1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChannelCardPreview() {
    MiChannelsTheme {
        ChannelCard(1, Channel("Channel", "safsf", "fsfsf")) {

        }
    }
}

