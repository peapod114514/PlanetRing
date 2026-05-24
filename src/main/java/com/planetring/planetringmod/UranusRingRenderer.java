//Copyright 2026 ___PEAPOD___

//        Licensed under the Apache License, Version 2.0 (the "License");
//        you may not use this file except in compliance with the License.
//        You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//        Unless required by applicable law or agreed to in writing, software
//        distributed under the License is distributed on an "AS IS" BASIS,
//        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//        See the License for the specific language governing permissions and
//        limitations under the License.

package com.planetring.planetringmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

class UranusRingRenderer {

    private static final ResourceLocation RING_TEXTURE = new ResourceLocation("planetring", "textures/environment/uranus_ring.png");
    private static final float RING_SIZE = 75.0f; //环的大小
    private static final float RING_Y_OFFSET = 125.0f; // 环的高度
    private static final float FOLLOW_Y_THRESHOLD = 50.0f; //在多少格跟着玩家移动
    private static final float FOLLOW_Y_OFFSET = 25.0f; //偏移高度
    //防止我忘了 环的高度+偏移高度=在多少格跟着玩家移动 这样可以做出不突兀的感觉 我能想出来这个我真是个天才 嘿嘿

    @SubscribeEvent
    public void renderWorldLast(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.player == null || mc.player.world.provider.getDimension() != -17) return;

        mc.getTextureManager().bindTexture(RING_TEXTURE);

        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);

        double playerX = mc.player.prevPosX + (mc.player.posX - mc.player.prevPosX) * event.getPartialTicks();
        double playerY = mc.player.prevPosY + (mc.player.posY - mc.player.prevPosY) * event.getPartialTicks();
        double playerZ = mc.player.prevPosZ + (mc.player.posZ - mc.player.prevPosZ) * event.getPartialTicks();

        float targetYOffset;
        if (playerY >= FOLLOW_Y_THRESHOLD) {
            targetYOffset = (float) (playerY - FOLLOW_Y_OFFSET);
        } else {
            targetYOffset = RING_Y_OFFSET;
        }

        GlStateManager.translate(0.0D, -playerY + targetYOffset, 0.0D);
        GlStateManager.rotate(97.77f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(0.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 0.0f, 1.0f);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);

        buffer.pos(-RING_SIZE, 0.0D, -RING_SIZE).tex(0.0D, 0.0D).endVertex();
        buffer.pos(RING_SIZE, 0.0D, -RING_SIZE).tex(1.0D, 0.0D).endVertex();
        buffer.pos(RING_SIZE, 0.0D, RING_SIZE).tex(1.0D, 1.0D).endVertex();
        buffer.pos(-RING_SIZE, 0.0D, RING_SIZE).tex(0.0D, 1.0D).endVertex();

        tessellator.draw();

        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}