package net.endermans.sapphire;

import net.java.games.input.Component.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {
 
    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(EntityTestingClient.MODEL_CUBE_LAYER)), 0.5f);
    }
 
    @Override
    public net.minecraft.util.Identifier getTexture(CubeEntity entity) {
        return new net.minecraft.util.Identifier("entitytesting", "textures/entity/cube/cube.png");
    }
}