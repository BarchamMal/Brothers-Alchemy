package net.barch.brosalch.Miscellaneous;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.brosalch.BrothersAlchemy.LOGGER;
import static net.barch.brosalch.BrothersAlchemy.NAMESPACE;

public class AlchemyComponents {

    public record SpellComponent(String spellItemId, int damage) {}

    public static final Codec<SpellComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.STRING.fieldOf("spell_item_id").forGetter(SpellComponent::spellItemId),
                Codec.INT.fieldOf("damage").forGetter(SpellComponent::damage)
        ).apply(builder, SpellComponent::new);
    });

    public static final ComponentType<SpellComponent> SPELL_COMPONENT_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(NAMESPACE, "spell_component_type"),
            ComponentType.<SpellComponent>builder().codec(CODEC).build()
    );

    public static void initialize() {
        LOGGER.info(("Registered Brother's Alchemy component types."));
    }

}
