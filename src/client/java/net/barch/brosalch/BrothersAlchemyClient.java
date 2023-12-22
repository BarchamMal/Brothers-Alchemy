package net.barch.brosalch;

import net.fabricmc.api.ClientModInitializer;

public class BrothersAlchemyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		TintItems.tint();

	}
}