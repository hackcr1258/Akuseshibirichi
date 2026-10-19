package hackcr.accessibility.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import hackcr.accessibility.akuseshibirichi;
import net.minecraft.client.render.ItemInHandRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemInHandRenderer.class)
public class HideItemRenderer {
	@Definition(id = "itemInHand", field = "Lnet/minecraft/client/render/ItemInHandRenderer;itemInHand:Lnet/minecraft/item/ItemStack;")
	@Expression("this.itemInHand != null")
	@ModifyExpressionValue(method = "renderInFirstPerson", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
	private boolean akuseshibirichi$HideItem(boolean original){
		return original && !akuseshibirichi.isZooming();
	}

	@ModifyExpressionValue(method = "renderInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/living/player/ClientPlayerEntity;isInvisible()Z"))
	private boolean akuseshibirichi$HideHand(boolean original){
		return original || akuseshibirichi.isZooming();
	}
}
