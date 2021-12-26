package xenor.cosmetics;

import java.io.IOException;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer>{
	
	protected final RenderPlayer playerRenderer;
	
	public CosmeticBase(RenderPlayer playerRenderer) {
		this.playerRenderer = playerRenderer;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float newHeadYaw, float headPitch, float scale) throws IOException {
		
		if(player.hasPlayerInfo() && !player.isInvisible()) {
			render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, newHeadYaw, headPitch, scale);
			
		}
		
	}
	
	public abstract void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float newHeadYaw, float headPitch, float scale);

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
