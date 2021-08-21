package net.endermans.sapphire;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SapphireToolMaterial implements ToolMaterial{
    public static final SapphireToolMaterial INSTANCE = new SapphireToolMaterial();

    @Override
    public int getDurability() {
        
        return 1500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        
        return 5.0f;
    }

    @Override
    public float getAttackDamage() {
        
        return 4.0f;
    }

    @Override
    public int getMiningLevel() {
        
        return 3;
    }

    @Override
    public int getEnchantability() {
        
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        
        return Ingredient.ofItems(EndermansSapphire.SAPPHIRE);
    }

    
}
