package net.barch.brosalch.Spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.crash.CrashException;
import net.minecraft.world.World;

import java.util.function.Consumer;

import static net.barch.brosalch.BrothersAlchemy.LOGGER;
import static net.barch.brosalch.Miscellaneous.Miscellaneous.TEACUP;

public class SprayBottleItem extends Item {
    public SprayBottleItem(Settings settings) {
        super(settings);
    }

    private NbtCompound nbtCompound;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack mainStack = user.getMainHandStack();
        ItemStack handStack = user.getStackInHand(hand);
        ItemStack offStack = user.getOffHandStack();

        nbtCompound = handStack.getOrCreateNbt();

        if (readNbt(handStack.getNbt()).getItem() == Items.AIR) {

            // The player must have the spray bottle in their mainhand in order to set the spell.
            if (mainStack != handStack) {
                return TypedActionResult.fail(handStack);
            }

            // The player must have a spell in their offhand in order to set the spell.
            if (!(offStack.getItem() instanceof SpellExtractItem)) {
                return TypedActionResult.fail(handStack);
            }

            writeNbt(offStack, nbtCompound);
            handStack.setNbt(nbtCompound);

            offStack.decrement(1);

            return TypedActionResult.success(handStack);

        }

        ItemStack spellStack = readNbt(nbtCompound);

        // The player can take the spell out of the spell bottle by shift-right clicking.
        if (user.isSneaking() && readNbt(handStack.getNbt()) != null) {

            if (!user.getInventory().insertStack(spellStack)) {
                user.dropItem(spellStack, false);
            }
            world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1, 1);

            clearSpellNbt(nbtCompound);

            return TypedActionResult.success(handStack, true);

        }

        ((SpellExtractItem)spellStack.getItem()).use(world, user, hand, spellStack);

        writeNbt(spellStack, nbtCompound);

        return TypedActionResult.success(handStack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        ItemStack handStack = context.getStack();

        nbtCompound = handStack.getOrCreateNbt();

        if (readNbt(handStack.getNbt()).getItem() == Items.AIR) {

            return ActionResult.FAIL;

        }

        ItemStack spellStack = readNbt(nbtCompound);

        ((SpellExtractItem)spellStack.getItem()).useOnBlock(context, readNbt(nbtCompound));

        writeNbt(spellStack, nbtCompound);

        return ActionResult.PASS;

    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        nbtCompound = stack.getOrCreateNbt();

        if (readNbt(stack.getNbt()).getItem() == Items.AIR) {

            return ActionResult.FAIL;

        }

        ItemStack spellStack = readNbt(nbtCompound);

        spellStack.getItem().useOnEntity(spellStack, user, entity, hand);

        writeNbt(spellStack, nbtCompound);

        return ActionResult.SUCCESS;
    }

    private void writeNbt(ItemStack itemStack, NbtCompound nbt) {
        // Make sure the player has something in their offhand before setting the spell to it.
        if (itemStack.getItem() != Items.AIR && itemStack != null) {
            NbtCompound nbt1 = new NbtCompound();
            nbt1.putInt("Damage", itemStack.getDamage());
            nbt1.putString("Type", Registries.ITEM.getId(itemStack.getItem()).toString());

            nbt.put("Spell", nbt1);
            return;
        }

        clearSpellNbt(nbt);
    }

    private void clearSpellNbt(NbtCompound nbt) {
        nbt.remove("Spell");
    }

    private ItemStack readNbt(NbtCompound nbt) {

        try {
            NbtCompound nbt1 = nbt.getCompound("Spell");

            ItemStack itemStack = Registries.ITEM.get(Identifier.tryParse(nbt1.getString("Type"))).getDefaultStack();

            itemStack.setDamage(nbt1.getInt("Damage"));

            return itemStack;
        }
        catch (CrashException var3) {
            LOGGER.info("Caught a crash at SprayBottleItem", var3);
            return null;
        }

    }

}
