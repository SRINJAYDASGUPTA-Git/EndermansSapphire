package net.endermans.sapphire;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SapphariteToolMaterial implements ToolMaterial{
    public static final SapphariteToolMaterial INSTANCE = new SapphariteToolMaterial();

    @Override
    public int getDurability() {
         
        return 2500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
         
        return 6.0f;
    }

    @Override
    public float getAttackDamage() {
         
        return 6.0f;
    }

    @Override
    public int getMiningLevel() {
         
        return 6;
    }

    @Override
    public int getEnchantability() {
         
        return 40;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
    
}
