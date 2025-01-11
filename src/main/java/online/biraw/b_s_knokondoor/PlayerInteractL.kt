package online.biraw.b_s_knokondoor

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class PlayerInteractL : Listener {
    
    private fun Play(location: Location, sound: Sound, v: Float, v1: Float){
        location.world.playSound(location,sound,v,v1)

    }
    
    @EventHandler
    fun playerKnock(event: PlayerInteractEvent) {
        val player = event.player
        

        if (event.action == Action.LEFT_CLICK_BLOCK && (player.inventory.itemInMainHand.isEmpty || B_s_KnockOnDoor.can_knock_with_tool)) {
            val blockType = event.clickedBlock?.type ?: return
            val location = event.clickedBlock!!.location

            when (blockType) {
                Material.PALE_OAK_DOOR -> {
                    Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 1f)
                    Play(location,Sound.ENTITY_CREAKING_SWAY,5f, 1f)
                }

                Material.OAK_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 1f)
                Material.SPRUCE_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.8f)
                Material.BIRCH_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.2f)
                Material.JUNGLE_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.3f)
                Material.ACACIA_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.5f)
                Material.DARK_OAK_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.7f)
                Material.MANGROVE_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.9f)
                Material.CHERRY_DOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.2f)
                Material.BAMBOO_DOOR -> Play(location, Sound.BLOCK_BAMBOO_HIT, 8f, 0.4f)
                Material.CRIMSON_DOOR -> Play(location, Sound.BLOCK_FUNGUS_PLACE, 6f, 0.4f)
                Material.WARPED_DOOR -> Play(location, Sound.BLOCK_FUNGUS_PLACE, 6f, 0.4f)
                Material.IRON_DOOR -> Play(location, Sound.BLOCK_LANTERN_PLACE, 6f, 0.5f)

                Material.COPPER_DOOR, Material.WAXED_COPPER_DOOR, Material.EXPOSED_COPPER_DOOR,
                Material.WAXED_EXPOSED_COPPER_DOOR, Material.WEATHERED_COPPER_DOOR,
                Material.WAXED_WEATHERED_COPPER_DOOR, Material.OXIDIZED_COPPER_DOOR,
                Material.WAXED_OXIDIZED_COPPER_DOOR ->
                    {
                        Play(location, Sound.BLOCK_LANTERN_PLACE, 6f, 0.5f)
                        Play(location, Sound.BLOCK_COPPER_PLACE, 6f, 0.5f)
                    }
                else -> {}
            }

            if (B_s_KnockOnDoor.can_knock_on_trapdoor) {
                when (blockType) {
                    Material.PALE_OAK_TRAPDOOR -> {
                        Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 1f)
                        Play(location,Sound.ENTITY_CREAKING_SWAY,5f, 1f)
                    }
                    Material.OAK_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 1f)
                    Material.SPRUCE_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.8f)
                    Material.BIRCH_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.2f)
                    Material.JUNGLE_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.3f)
                    Material.ACACIA_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.5f)
                    Material.DARK_OAK_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.7f)
                    Material.MANGROVE_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 5f, 0.9f)
                    Material.CHERRY_TRAPDOOR -> Play(location, Sound.ITEM_SHIELD_BLOCK, 3f, 1.2f)
                    Material.BAMBOO_TRAPDOOR -> Play(location, Sound.BLOCK_BAMBOO_HIT, 8f, 0.4f)
                    Material.CRIMSON_TRAPDOOR -> Play(location, Sound.BLOCK_FUNGUS_PLACE, 6f, 0.4f)
                    Material.WARPED_TRAPDOOR -> Play(location, Sound.BLOCK_FUNGUS_PLACE, 6f, 0.4f)
                    Material.IRON_TRAPDOOR -> Play(location, Sound.BLOCK_LANTERN_PLACE, 6f, 0.5f)

                    Material.COPPER_TRAPDOOR, Material.WAXED_COPPER_TRAPDOOR, Material.EXPOSED_COPPER_TRAPDOOR,
                    Material.WAXED_EXPOSED_COPPER_TRAPDOOR, Material.WEATHERED_COPPER_TRAPDOOR,
                    Material.WAXED_WEATHERED_COPPER_TRAPDOOR, Material.OXIDIZED_COPPER_TRAPDOOR,
                    Material.WAXED_OXIDIZED_COPPER_TRAPDOOR ->
                        {
                            Play(location, Sound.BLOCK_LANTERN_PLACE, 6f, 0.7f)
                            Play(location, Sound.BLOCK_COPPER_PLACE, 6f, 0.7f)
                        }
                    else -> {}
                }
            }
        }
    }
}
