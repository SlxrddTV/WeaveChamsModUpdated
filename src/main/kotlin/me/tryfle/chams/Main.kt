package me.tryfle.chams

import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.weavemc.api.ChatSentEvent
import net.weavemc.api.ModInitializer
import net.weavemc.api.RenderLivingEvent
import net.weavemc.api.event.EventBus
import net.weavemc.api.event.SubscribeEvent
import org.lwjgl.opengl.GL11

class Main : ModInitializer {

    companion object {
        var enabled = false
    }

    override fun init() {
        println("[ChamsMod] Chams Mod has been loaded!")
        EventBus.subscribe(this)
    }

    @SubscribeEvent
    fun onChat(event: ChatSentEvent) {
        if (event.message.trim() == "/togglechams") {
            event.cancelled = true
            enabled = !enabled
            val mc = Minecraft.getMinecraft()
            mc.thePlayer?.addChatMessage(
                ChatComponentText("${EnumChatFormatting.AQUA}[ChamsMod] Chams have been ${if (enabled) "enabled" else "disabled"}!")
            )
        }
    }

    @SubscribeEvent
    fun onPreLivingRender(event: RenderLivingEvent.Pre) {
        if (event.entity is EntityPlayer && event.entity != Minecraft.getMinecraft().thePlayer) {
            if (enabled) {
                GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL)
                GL11.glPolygonOffset(1.0f, -1000000.0f)
            }
        }
    }

    @SubscribeEvent
    fun onPostLivingRender(event: RenderLivingEvent.Post) {
        if (event.entity is EntityPlayer && event.entity != Minecraft.getMinecraft().thePlayer) {
            if (enabled) {
                GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL)
                GL11.glPolygonOffset(1.0f, 1000000.0f)
            }
        }
    }
}
