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
	public static final Block SAPPHIRE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SAPPHIRE_ORE = new SapphireOreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
    private static ConfiguredFeature<?, ?> SAPPHIRE_ORE_OVERWORLD=Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SAPPHIRE_ORE.getDefaultState(),9)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(16)))).spreadHorizontally().repeat(20));
	public static final ToolItem SAPPHIRE_SWORD = new SwordItem(SapphireToolMaterial.INSTANCE, 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHIRE_SHOVEL = new ShovelItem(SapphireToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_PICKAXE = new CustomPickaxeItem(SapphireToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_AXE = new CustomAxeItem(SapphireToolMaterial.INSTANCE, 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHIRE_HOE = new CustomHoeItem(SapphireToolMaterial.INSTANCE, 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_SWORD = new SwordItem(SapphariteToolMaterial.INSTANCE, 8, -2.6f, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ToolItem SAPPHARITE_SHOVEL = new ShovelItem(SapphariteToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_PICKAXE = new CustomPickaxeItem(SapphariteToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_AXE = new CustomAxeItem(SapphariteToolMaterial.INSTANCE, 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ToolItem SAPPHARITE_HOE = new CustomHoeItem(SapphariteToolMaterial.INSTANCE, 7, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));






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
		RegistryKey<ConfiguredFeature<?, ?>> sapphireOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("enderman", "sapphire_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sapphireOreOverworld.getValue(), SAPPHIRE_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sapphireOreOverworld);
        
    }
    
}
