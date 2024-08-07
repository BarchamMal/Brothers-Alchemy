package net.barch.brosalch;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import static net.barch.brosalch.Spells.Spells.BOLT_OF_ICE_ENTITY_TYPE;

public class BrothersAlchemyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		TintItems.tint();
		ClientParticleFX.onInitialize();

		EntityRendererRegistry.register(BOLT_OF_ICE_ENTITY_TYPE, FlyingItemEntityRenderer::new);

	}
	// CARROT color was 0xff8e09
	// APPLE color was 0xff9d5b
	// SWEET_BERRY color was 0xff0022
    // MELON color was 0xff3f59
	// BEET color was 0xff2200
	// CHORUS color was 0x5e2e5c
    // COCOA color was 0x704425
	// GLOW_BERRY color was 0xfff165
	// MUSHROOM color was 0xcc9978
	// POTATO color was 0xecee79
	// PUMPKIN color was 0xff8a00
	// SEAWEED color was 0x3cb37f
	// SUGAR color was 0xa0ff98
	// WHEAT color was 0xd89150

}