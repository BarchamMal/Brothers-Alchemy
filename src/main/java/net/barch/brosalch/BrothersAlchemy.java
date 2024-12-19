package net.barch.brosalch;

import net.barch.barch_lib.Items.ItemGrouper;
import net.barch.brosalch.MagicIngredients.MagicIngredients;
import net.barch.brosalch.Miscellaneous.AlchemyComponents;
import net.barch.brosalch.Miscellaneous.Miscellaneous;
import net.barch.brosalch.Spells.Spell;
import net.barch.brosalch.Spells.SpellExtractItem;
import net.barch.brosalch.Spells.Spells;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
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

import java.lang.reflect.Constructor;

import static net.barch.brosalch.Miscellaneous.Miscellaneous.TEACUP;
import static net.barch.brosalch.Spells.Spells.LIGHT_EXTRACT;

public class BrothersAlchemy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("brothers-alchemy");

	public static final String NAMESPACE = "brothers-alchemy";

	public static final RegistryKey<ItemGroup> BROTHERS_ALCHEMY_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(NAMESPACE, "brothers_alchemy"));
	public static final RegistryKey<ItemGroup> SPELLS_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(NAMESPACE, "spells"));


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

		Registry.register(Registries.ITEM_GROUP, SPELLS_GROUP, FabricItemGroup.builder()
				.icon(() -> new ItemStack(LIGHT_EXTRACT))
				.displayName(Text.translatable("itemGroup."+NAMESPACE+".spells"))
				.build());

		MagicIngredients.RegisterAll();
		Miscellaneous.RegisterAll();
		Spells.RegisterAll();

		AlchemyComponents.initialize();

	}


	public static Item createItem(String name, Class<? extends Item> itemClass, Item.Settings settings) {
		Identifier id = Identifier.of(NAMESPACE, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

		try {
			// Get the constructor that accepts Item.Settings as a parameter
			Constructor<? extends Item> constructor = itemClass.getConstructor(Item.Settings.class);
			// Create a new instance using the constructor
			Item item = constructor.newInstance(settings.registryKey(key));
			// Register the item and return it
			return Registry.register(Registries.ITEM, key, item);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create item: " + name, e);
		}
	}

	public static Item createItem(String name, Item.Settings settings, FoodComponent foodComponent, ConsumableComponent consumableComponent) {
		Identifier id = Identifier.of(NAMESPACE, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

		return Registry.register(Registries.ITEM, key, new Item(settings.registryKey(key).food(foodComponent, consumableComponent)));
	}

	public static TeaItem createItem(String name, Item.Settings settings, StatusEffectInstance effectInstance) {
		Identifier id = Identifier.of(NAMESPACE, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

		return Registry.register(Registries.ITEM, key, new TeaItem(settings.registryKey(key), effectInstance));
	}

	public static SpellExtractItem createItem(String name, Item.Settings settings, Spell spell) {
		Identifier id = Identifier.of(NAMESPACE, name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

		return Registry.register(Registries.ITEM, key, new SpellExtractItem(settings.registryKey(key), spell));
	}

}