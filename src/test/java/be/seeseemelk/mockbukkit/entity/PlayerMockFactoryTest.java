package be.seeseemelk.mockbukkit.entity;

import be.seeseemelk.mockbukkit.MockBukkit;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerMockFactoryTest
{
	private PlayerMockFactory factory;

 	@BeforeEach
	public void setUp() throws Exception
	{
 		MockBukkit.mock();
 		factory = new PlayerMockFactory();
	}
 	
 	@AfterEach
 	public void tearDown()
 	{
 		MockBukkit.unload();
 	}

	@Test
	public void createRandomPlayer_createsRandomPlayer()
	{
		Player player = factory.createRandomPlayer();
		assertNotNull(player.getName());
		assertNotNull(player.getUniqueId());
	}
	
	@Test
	public void createRandomPlayer_TwoInvocations_DifferentPlayers()
	{
		Player player1 = factory.createRandomPlayer();
		Player player2 = factory.createRandomPlayer();
		assertFalse(player1.equals(player2), "Two random players are the same");
	}

}
