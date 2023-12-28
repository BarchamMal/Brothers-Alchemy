package net.barch.brosalch;

import net.barch.brosalch.Glue.ItemGrouper;
import net.barch.brosalch.MagicIngredients.MagicIngredients;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.barch.brosalch.Miscellaneous.Miscellaneous.TEACUP;

public class BrothersAlchemy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("brothers-alchemy");

	public static final String NAMESPACE = "brothers-alchemy";

	public static final RegistryKey<ItemGroup> BROTHERS_ALCHEMY_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "brothers_alchemy"));


	public static final ItemGrouper BAItemGrouper = new ItemGrouper(BROTHERS_ALCHEMY_GROUP);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.ITEM_GROUP, BROTHERS_ALCHEMY_GROUP, FabricItemGroup.builder()
				.icon(() -> new ItemStack(TEACUP))
				.displayName(Text.translatable("itemGroup."+NAMESPACE+".brothers-alchemy"))
				.build());

		MagicIngredients.RegisterAll();
		Miscellaneous.RegisterAll();

	}
}