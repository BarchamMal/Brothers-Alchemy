package net.barch.brosalch.Miscellaneous;

import net.barch.brosalch.Glue.ItemGroupItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.*;

public class Miscellaneous {

    public static final int TICKS = 20;
    public static final int SECONDS = 60;

    public static final int TEA_TIME = (1*TICKS)*SECONDS;
    public static final int COOKIE_TIME = (20*TICKS);

    public static final int TEA_STRENGTH = 0;
    public static final int COOKIE_STRENGTH = 2;


    public static final Item TEACUP = new Item(new FabricItemSettings());
    public static final Item DIAMOND_PULPIFIER = new Item(new FabricItemSettings().maxCount(1));



    public static void RegisterAll() {
        RegisterItems();
        GroupItems();
    }

    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "teacup"), TEACUP);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "diamond_pulpifier"), DIAMOND_PULPIFIER);

        LOGGER.info(Registries.ITEM.getId(DIAMOND_PULPIFIER.getRecipeRemainder()).toTranslationKey());
    }

    public static void GroupItems() {
        BAItemGrouper.GroupItem(TEACUP, new ItemGroupItem[]{new ItemGroupItem(ItemGroups.INGREDIENTS, Items.GLASS_BOTTLE)});
    }


}
