package net.barch.brosalch.Spells;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class UnusedItems {

    public static final Item RAY_OF_FROST = new Item(new FabricItemSettings());

    public static void RegisterAll() {
        RegisterItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "ray_of_frost_item"), RAY_OF_FROST);
    }
}
