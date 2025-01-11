package online.biraw.b_s_knokondoor

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class B_s_KnockOnDoor : JavaPlugin() {

    companion object {
        lateinit var instance: B_s_KnockOnDoor
            private set
        var can_knock_with_tool: Boolean = true
        var can_knock_on_trapdoor: Boolean = false
    }

    override fun onEnable() {
        //Register Listeners

        instance = this

        server.pluginManager.registerEvents(PlayerInteractL(),this)
        if(!dataFolder.exists()){dataFolder.mkdirs()}
        val configFile = File(dataFolder,"B's KnockOnDoor Config.yml")
        if (!configFile.exists()){
            configFile.createNewFile()
            val config = YamlConfiguration.loadConfiguration(configFile)
            config.set("can_knock_on_trapdoor",true)
            config.setComments("can_knock_on_trapdoor", listOf("This determines whether you can knock on trapdoors."))
            config.set("can_knock_with_tool",false)
            config.setComments("can_knock_with_tool", listOf("If this set true, a player can knock with any item in hand.","If set false, a player can only knock if has nothing in the main hand."))
            config.save(configFile)
        }else{
            val config = YamlConfiguration.loadConfiguration(configFile)

            if (config.contains("can_knock_on_trapdoor")) {
                can_knock_on_trapdoor = config.getBoolean("can_knock_on_trapdoor")
            } else {
                logger.warning("'can_knock_on_trapdoor' is not properly set in the config, so it's set to 'true' as default!")
                config.set("can_knock_on_trapdoor",true)
                can_knock_on_trapdoor = config.getBoolean("can_knock_on_trapdoor")
            }


            if (config.contains("can_knock_with_tool")) {
                can_knock_with_tool = config.getBoolean("can_knock_with_tool")
            } else {
                logger.info("'can_knock_with_tool' is not properly set in the config, so it's set to 'false' as default!")
                config.set("can_knock_with_tool",false)
                can_knock_with_tool = config.getBoolean("can_knock_with_tool")
            }

            config.save(configFile)
        }


        logger.info("The B's KnockOnDoor plugin loaded successfully.")
        logger.info("This is B's KnockOnDoor for minecraft JDK 21.")
        logger.info("Author: BiRaw")
        logger.info("Please check out my other plugins on modrinth.com")

    }

    override fun onDisable() {
        logger.info("The B's KnockOnDoor plugin is unloaded.")
    }
}
