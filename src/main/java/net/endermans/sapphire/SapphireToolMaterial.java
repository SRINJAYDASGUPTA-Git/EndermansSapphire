package net.endermans.sapphire;

import net.fabricmc.fabric.impl.tool.attribute.ToolManagerImpl.ToolHandler;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SapphireToolMaterial implements ToolMaterial{

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        return 1500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 9.0f;
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 4.0f;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(EndermansSapphire.SAPPHIRE  );
    }

    
}
