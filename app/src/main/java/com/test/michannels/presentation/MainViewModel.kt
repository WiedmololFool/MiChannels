package com.test.michannels.presentation

import androidx.lifecycle.ViewModel
import com.test.michannels.model.Channel

class MainViewModel : ViewModel() {

    fun generateChannelList(): List<Channel> {
        return listOf(
            Channel("A", "afaf", "afsafsf"),
            Channel("B", "afaf", "afsafsf"),
            Channel("C", "afaf", "afsafsf"),
            Channel("D", "afaf", "afsafsf"),
            Channel("E", "afaf", "afsafsf"),
            Channel("F", "afaf", "afsafsf"),
            Channel("G", "afaf", "afsafsf"),
        )
    }
}