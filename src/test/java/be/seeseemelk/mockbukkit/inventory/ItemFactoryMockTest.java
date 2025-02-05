package be.seeseemelk.mockbukkit.inventory;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.inventory.meta.ItemMetaMock;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemFactoryMockTest
{
	private ItemFactoryMock factory;
	
	@BeforeEach
	public void setUp()
	{
		MockBukkit.mock();
		factory = new ItemFactoryMock();
	}
	
	@AfterEach
	public void tearDown()
	{
		MockBukkit.unload();
	}
	
	/*
	 * These tests are still very incomplete as the ItemFactoryMock for now only
	 * supports the creation of ItemMetaMock objects.
	 */
	
	@Test
	public void getItemMeta_Stick_StandardItemMeta()
	{
		assertTrue(factory.getItemMeta(Material.DIRT) instanceof ItemMetaMock);
	}
	
	@Test
	public void isApplicable_StandardItemMetaOnDirtMaterial_True()
	{
		ItemMeta meta = factory.getItemMeta(Material.DIRT);
		assertTrue(factory.isApplicable(meta, Material.DIRT));
	}
	
	@Test
	public void isApplicable_StandardItemMetaOnDirtItemStack_True()
	{
		ItemStack stack = new ItemStack(Material.DIRT);
		ItemMeta meta = factory.getItemMeta(Material.DIRT);
		assertTrue(factory.isApplicable(meta, stack));
	}
	
	@Test
	public void equals_NullAndNull_False()
	{
		assertFalse(factory.equals(null, null));
	}
	
	@Test
	public void equals_MetaAndNull_False()
	{
		ItemMeta meta = factory.getItemMeta(Material.DIRT);
		assertFalse(factory.equals(meta, null));
	}
	
	@Test
	public void equals_NullAndMeta_False()
	{
		ItemMeta meta = factory.getItemMeta(Material.DIRT);
		assertFalse(factory.equals(null, meta));
	}
	
	@Test
	public void equals_CompatibleMetas_True()
	{
		ItemMeta a = factory.getItemMeta(Material.DIRT);
		ItemMeta b = factory.getItemMeta(Material.DIRT);
		assertTrue(factory.equals(a, b));
	}
	
	@Test
	public void asMetaFor_DirtItemMetaOnDirtMaterial_ReturnsCloneOfMeta()
	{
		ItemMeta meta = factory.getItemMeta(Material.DIRT);
		meta.setDisplayName("My piece of dirt");
		ItemMeta newMeta = factory.asMetaFor(meta, Material.DIRT);
		assertTrue(meta.equals(newMeta));
	}
	
	@Test
	public void asMetaFor_DirtItemMetaOnDirtItemStack_ReturnsCloneOfMeta()
	{
		ItemStack stack = new ItemStack(Material.DIRT);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("My piece of dirt");
		stack.setItemMeta(meta);
		
		ItemMeta newMeta = factory.asMetaFor(meta, stack);
		assertTrue(meta.equals(newMeta));
	}
}



























