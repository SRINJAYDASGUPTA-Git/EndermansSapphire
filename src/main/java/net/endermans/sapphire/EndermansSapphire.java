package net.endermans.sapphire;
import javax.tools.Tool;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class EndermansSapphire implements ModInitializer{
    public static final Item SAPPHIRE = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.0F).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SAPPHIRE_ORE = new SapphireOreBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
    private static ConfiguredFeature<?, ?> SAPPHIRE_ORE_OVERWORLD=Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SAPPHIRE_ORE.getDefaultState(),9)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(16)))).spreadHorizontally().repeat(20));
	public static final ToolItem SAPPHIRE_SWORD = new SwordItem(new SapphireToolMaterial(), 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(new SapphireToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(new SapphireToolMaterial(), 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_AXE = new CustomAxeItem(new SapphireToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_HOE = new CustomHoeItem(new SapphireToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_SWORD = new SwordItem(new SapphariteToolMaterial(), 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHARITE_SHOVEL = new ShovelItem(new SapphariteToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_PICKAXE = new CustomPickaxeItem(new SapphariteToolMaterial(), 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_AXE = new CustomAxeItem(new SapphariteToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_HOE = new CustomHoeItem(new SapphariteToolMaterial(), 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ArmorMaterial SAPPHIRE_MATERIAL = new SapphireArmorMaterial();
	public static final ArmorMaterial SAPPHARITE_MATERIAL = new SapphariteArmorMaterial();
	public static final Item SAPPHIRE_HELMET = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(SAPPHIRE_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item SAPPHARITE_HELMET = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHARITE_CHESTPLATE = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHARITE_LEGGINGS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SAPPHARITE_BOOTS = new ArmorItem(SAPPHARITE_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));



    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire"), SAPPHIRE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_sword"), SAPPHIRE_SWORD);		
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_shovel"), SAPPHIRE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_pickaxe"), SAPPHIRE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_axe"), SAPPHIRE_AXE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_hoe"), SAPPHIRE_HOE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_sword"), SAPPHARITE_SWORD);		
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_shovel"), SAPPHARITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_pickaxe"), SAPPHARITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_axe"), SAPPHARITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_hoe"), SAPPHARITE_HOE);
		Registry.register(Registry.BLOCK, new Identifier("enderman", "sapphire_block"), SAPPHIRE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_block"), new BlockItem(SAPPHIRE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("enderman","sapphire_ore"), SAPPHIRE_ORE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_ore"), new BlockItem(SAPPHIRE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_helmet"), SAPPHIRE_HELMET);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_leggings"), SAPPHIRE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sapphire_boots"), SAPPHIRE_BOOTS);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_helmet"), SAPPHARITE_HELMET);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_chestplate"), SAPPHARITE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_leggings"), SAPPHARITE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("enderman", "sappharite_boots"), SAPPHARITE_BOOTS);
		RegistryKey<ConfiguredFeature<?, ?>> sapphireOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("enderman", "sapphire_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sapphireOreOverworld.getValue(), SAPPHIRE_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sapphireOreOverworld);
        
    }
    
}
