package net.barch.brosalch;

import net.barch.brosalch.MagicIngredients.*;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class TintItems {

    public static void tint() {

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff8e09, CarrotIngredients.CARROT_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff9d5b, AppleIngredients.APPLE_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff0022, SweetBerryIngredients.SWEET_BERRY_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff3f59, MelonIngredients.MELON_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff2200, BeetIngredients.BEET_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e2e5c, ChorusIngredients.CHORUS_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x704425, CocoaIngredients.COCOA_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfff165, GlowBerryIngredients.GLOW_BERRY_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xcc9978, MushroomIngredients.MUSHROOM_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xecee79, PotatoIngredients.POTATO_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xff8a00, PumpkinIngredients.PUMPKIN_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3cb37f, SeaweedIngredients.SEAWEED_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xa0ff98, SugarIngredients.SUGAR_PULP);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xd89150, WheatIngredients.WHEAT_PULP);

    }

}
