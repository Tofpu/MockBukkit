package be.seeseemelk.mockbukkit.inventory;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PlayerInventoryViewTest
{
	private ServerMock server;

	@BeforeEach
	public void setUp() throws Exception
	{
		server = MockBukkit.mock();
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		MockBukkit.unload();
	}
	
	@Test
	public void constructor_SetsProperties()
	{
		Player player = server.addPlayer();
		Inventory inventory = new SimpleInventoryMock(null, null, 9, InventoryType.CHEST);
		
		PlayerInventoryViewMock view = new PlayerInventoryViewMock(player, inventory);
		assertSame(player, view.getPlayer());
		assertSame(player.getInventory(), view.getBottomInventory());
		assertSame(inventory, view.getTopInventory());
	}
	
}
