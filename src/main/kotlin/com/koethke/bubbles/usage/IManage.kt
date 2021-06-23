package com.koethke.bubbles.usage

interface IManage {

    fun plug(outputNodeID : String, inputNodeID: String, outputValueKey : String, inputValueKey: String)

    fun unplug(outputNodeID : String, inputNodeID: String, outputValueKey : String, inputValueKey: String)

    fun unplugAllIncoming(nodeID: String)

}