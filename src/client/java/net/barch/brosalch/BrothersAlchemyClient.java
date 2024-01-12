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

		EntityRendererRegistry.register(BOLT_OF_ICE_ENTITY_TYPE, (context) ->
				new FlyingItemEntityRenderer(context));

	}
}