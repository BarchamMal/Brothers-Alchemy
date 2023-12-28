package net.barch.brosalch.mixin;


import net.barch.brosalch.Miscellaneous.Tags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Shadow public abstract ItemStack getDefaultStack();

    @Inject(at = @At("TAIL"), method = "getRecipeRemainder", cancellable = true)
    private void init(CallbackInfoReturnable<Item> cir) {
        if (this.getDefaultStack().isIn(Tags.CRAFTING_TOOLS)) {
            cir.setReturnValue(this.getDefaultStack().getItem());
        }
    }
}