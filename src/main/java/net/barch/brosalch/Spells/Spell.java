package net.barch.brosalch.Spells;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.barch.brosalch.Spells.Spells.SPELL_COOLDOWN;

public class Spell {

    private int SPELL_STATUS;
    private String SPELL_TYPE;

    public Spell(int spellStatus, String spellType) {
        this.SPELL_STATUS = spellStatus;
        this.SPELL_TYPE = spellType;
    }

    public String getMiningLevel(BlockState blockState) {

        if (blockState.isIn(BlockTags.NEEDS_DIAMOND_TOOL))
            return "diamond";
        if (blockState.isIn(BlockTags.NEEDS_IRON_TOOL))
            return "iron";
        if (blockState.isIn(BlockTags.NEEDS_STONE_TOOL))
            return "stone";
        return "wood";

    }


    public void damageSolo(ItemStack stack, PlayerEntity user) {
        if (!user.isCreative()) stack.setDamage(stack.getDamage() + 8);
    }

    public void damageSpray(ItemStack stack, PlayerEntity user) {
        if (!user.isCreative()) stack.setDamage(stack.getDamage() + 1);
    }

    public int getSpellStatus() {
        return SPELL_STATUS;
    }

    public String getSpellType() {
        return SPELL_TYPE;
    }

    public ActionResult useAir(World world, PlayerEntity user, Hand hand, @Nullable ItemStack itemStack) {
        return ActionResult.SUCCESS;
    }

    public ActionResult useEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return ActionResult.SUCCESS;
    }

    public ActionResult useBlock(ItemUsageContext context, @Nullable ItemStack itemStack) {
        return ActionResult.SUCCESS;
    }

    public void simpleUseOnBlock(World world, PlayerEntity user, Hand hand, ItemUsageContext context, Item item) {
        // The reason for the whole "fake context" thing is to prevent the player losing their spray bottle or spell via this method.
        ItemStack use = item.getDefaultStack();
        ItemUsageContext fakeContext = new ItemUsageContext(world, user, hand, use, new BlockHitResult(context.getHitPos(), context.getSide(),context.getBlockPos(), context.hitsInsideBlock()));
        use.useOnBlock(fakeContext);
    }

    public ActionResult simpleDamage(PlayerEntity user, Hand hand, ItemStack itemStack) {


        ItemStack sprayBottleStack = user.getStackInHand(hand);

        // Spray bottles use _much_ less durability...
        if (sprayBottleStack.getItem() == Spells.SPRAY_BOTTLE) {
            damageSpray(itemStack, user);
            ((SpellExtractItem)itemStack.getItem()).onBreak(itemStack, user.getWorld(), user);
            user.getItemCooldownManager().set(user.getStackInHand(hand),  SPELL_COOLDOWN);
            return ActionResult.SUCCESS;
        }

        //... than raw spells.
        damageSolo(user.getStackInHand(hand), user);
        ((SpellExtractItem)user.getStackInHand(hand).getItem()).onBreak(user.getStackInHand(hand), user.getWorld(), user);
        user.getItemCooldownManager().set(user.getStackInHand(hand),  SPELL_COOLDOWN);
        return ActionResult.SUCCESS;

    }

    public ActionResult simpleFinishUsingAir(PlayerEntity user, Hand hand, ItemStack itemStack) {

        if (user.getStackInHand(hand).getItem() == Spells.SPRAY_BOTTLE) {
            damageSpray(itemStack, user);
            ((SpellExtractItem)itemStack.getItem()).onBreak(itemStack, user.getWorld(), user);

            user.getItemCooldownManager().set(user.getStackInHand(hand),  SPELL_COOLDOWN);
            return ActionResult.SUCCESS;
        }

        damageSolo(user.getStackInHand(hand), user);
        ((SpellExtractItem)user.getStackInHand(hand).getItem()).onBreak(user.getStackInHand(hand), user.getWorld(), user);

        user.getItemCooldownManager().set(user.getStackInHand(hand),  SPELL_COOLDOWN);
        return ActionResult.SUCCESS;

    }


}
