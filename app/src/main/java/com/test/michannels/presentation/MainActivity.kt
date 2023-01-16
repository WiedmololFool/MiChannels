package com.test.michannels.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.michannels.ui.ChannelsList
import com.test.michannels.ui.theme.MiChannelsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiChannelsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChannelsList(
                        loading = false,
                        channels = viewModel.generateChannelList(),
                        onChangeScrollPosition = { indexOfChannel ->
                            println("TAG, $indexOfChannel")
                        },
                        onChannelClick = { index, channel ->
                            Toast.makeText(
                                applicationContext,
                                "$index : $channel",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        modifier = Modifier,
        text = "Hello $name!"
    )
}


private fun startTelegramChannel(context: Context) {
    val tgIntent = createTelegramIntent(context)
    tgIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    context.startActivity(tgIntent)
}

private fun createTelegramIntent(context: Context): Intent {
    val intent = try {
        try {
            context.packageManager.getPackageInfo(
                "org.telegram.messenger",
                0
            )//Check for Telegram Messenger App
        } catch (e: Exception) {
            context.packageManager.getPackageInfo(
                "org.thunderdog.challegram",
                0
            )//Check for Telegram X App
        }
        Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=$TELEGRAM_PAGE_ID"))
    } catch (e: Exception) { //App not found open in browser
        Intent(Intent.ACTION_VIEW, Uri.parse("http://www.telegram.me/$TELEGRAM_PAGE_ID"))
    }
    return intent
}


const val TELEGRAM_PAGE_ID = "yurasumy"


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MiChannelsTheme {
        Greeting("Android")
    }
}