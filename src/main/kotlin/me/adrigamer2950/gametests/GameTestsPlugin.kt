package me.adrigamer2950.gametests

import me.adrigamer2950.adriapi.api.APIPlugin

class GameTestsPlugin : APIPlugin() {

    override fun onPreLoad() {
        logger.info("&6Loading...")
    }

    override fun onPostLoad() {
        logger.info("&aEnabled")
    }

    override fun onUnload() {
        logger.info("&cDisabled")
    }
}
