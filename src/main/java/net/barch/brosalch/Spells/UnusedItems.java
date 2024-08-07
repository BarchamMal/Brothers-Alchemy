package net.barch.brosalch.Spells;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class UnusedItems {

    public static final Item RAY_OF_FROST = new Item(new Item.Settings());

    public static void RegisterAll() {
        RegisterItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, Identifier.of(NAMESPACE, "bolt_of_ice_item"), RAY_OF_FROST);
    }
}
