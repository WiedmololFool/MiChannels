package com.test.michannels.data

import com.test.michannels.model.Channel

interface ChannelsRepository {

    fun getChannels() : List<Channel>

}