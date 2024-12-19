package net.barch.brosalch.Spells;

import net.barch.brosalch.Miscellaneous.AlchemyComponents;
import net.minecraft.component.ComponentMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

import static net.barch.brosalch.BrothersAlchemy.LOGGER;

public class SprayBottleItem extends Item {
    public SprayBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        ComponentMap components = stack.getComponents();

        if (!components.contains(AlchemyComponents.SPELL_COMPONENT_TYPE)) {
            stack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent("minecraft:air", 0));
            return;
        }
        if (components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId().contentEquals("minecraft:air")) return;


        ItemStack spell = Registries.ITEM.get(Identifier.tryParse(stack.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId())).getDefaultStack();
        spell.setDamage(stack.get(AlchemyComponents.SPELL_COMPONENT_TYPE).damage());

        tooltip.add(Text.translatable(spell.getItem().getTranslationKey()).formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("item.brothers-alchemy.spray_bottle.uses").append(" " + (spell.getMaxDamage() - spell.getDamage())).formatted(Formatting.GREEN));

    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        ItemStack mainStack = user.getMainHandStack();
        ItemStack handStack = user.getStackInHand(hand);
        ItemStack offStack = user.getOffHandStack();

        ComponentMap components = handStack.getComponents();

        // if there is no spell_component_type, (possible via commands) add one
        if (!components.contains(AlchemyComponents.SPELL_COMPONENT_TYPE)) {
            handStack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent("minecraft:air", 0));
            components = handStack.getComponents();
        }

        // if there is a spell_component_type, but it's just air, then we try to fill it up with a stack in their offHand if there is one.
        if (Registries.ITEM.get(Identifier.tryParse(handStack.getComponents().get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId())) == Items.AIR) {
            if (mainStack!=handStack) {
                return ActionResult.FAIL;
            }
            if (!(offStack.getItem() instanceof SpellExtractItem)) {
                return ActionResult.FAIL;
            }

            handStack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent(Registries.ITEM.getId(offStack.getItem()).toString(), offStack.getDamage()));
            offStack.decrement(1);
            return ActionResult.FAIL;
        }

        // if we've gotten to here, it means that we are dealing with a full spray bottle.
        ItemStack spellStack = Registries.ITEM.get(Identifier.tryParse(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId())).getDefaultStack();
        spellStack.setDamage(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).damage());


        // if they're sneaking then we pull out the spray bottle
        if (user.isSneaking()) {

            if (world instanceof ServerWorld && !user.getInventory().insertStack(spellStack) ) {
                user.dropStack((ServerWorld) world,spellStack);
            }
            world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1, 1);
            handStack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent("minecraft:air", 0));

            return ActionResult.SUCCESS;

        }

        ((SpellExtractItem)spellStack.getItem()).use(world, user, hand, spellStack);
        handStack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent(Registries.ITEM.getId(spellStack.getItem()).toString(), spellStack.getDamage()));
        return ActionResult.SUCCESS;

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        ItemStack stack = context.getStack();

        ComponentMap components = stack.getComponents();

        if (!components.contains(AlchemyComponents.SPELL_COMPONENT_TYPE)) {
            stack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent("minecraft:air", 0));
            return ActionResult.FAIL;
        }
        if (components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId().contentEquals("minecraft:air") || context.getPlayer().isSneaking()) return ActionResult.FAIL;

        ItemStack spellStack = Registries.ITEM.get(Identifier.tryParse(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId())).getDefaultStack();
        spellStack.setDamage(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).damage());

        ((SpellExtractItem)spellStack.getItem()).useOnBlock(context, spellStack);

        stack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent(Registries.ITEM.getId(spellStack.getItem()).toString(), spellStack.getDamage()));
        return ActionResult.SUCCESS;

    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        ComponentMap components = stack.getComponents();

        if (!components.contains(AlchemyComponents.SPELL_COMPONENT_TYPE)) {
            stack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent("minecraft:air", 0));
            return ActionResult.FAIL;
        }
        if (components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId().contentEquals("minecraft:air") || user.isSneaking()) return ActionResult.FAIL;

        ItemStack spellStack = Registries.ITEM.get(Identifier.tryParse(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).spellItemId())).getDefaultStack();
        spellStack.setDamage(components.get(AlchemyComponents.SPELL_COMPONENT_TYPE).damage());

        spellStack.getItem().useOnEntity(spellStack, user, entity, hand);

        stack.set(AlchemyComponents.SPELL_COMPONENT_TYPE, new AlchemyComponents.SpellComponent(Registries.ITEM.getId(spellStack.getItem()).toString(), spellStack.getDamage()));
        return ActionResult.SUCCESS;

    }

}
