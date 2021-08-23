package net.endermans.sapphire;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item.Settings;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.EquipmentSlot;

public class SapphireArmorMaterial implements ArmorMaterial{
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {2, 5, 6, 3};

    @Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 25;
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 25;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(EndermansSapphire.SAPPHIRE);
	}
 
	@Override
	public String getName() {
		return "Sapphire";
	}
 
	@Override
	public float getToughness() {
		return 2.0F;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}
} 