package be.seeseemelk.mockbukkit.scoreboard;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.scoreboard.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectiveMockTest
{
	private ServerMock server;
	private ScoreboardMock scoreboard;
	private ObjectiveMock objective;

	@BeforeEach
	public void setUp() throws Exception
	{
		server = MockBukkit.mock();
		scoreboard = new ScoreboardMock();
		objective = scoreboard.registerNewObjective("Objective", "dummy");
	}
	
	@AfterEach
	public void tearDown() throws Exception
	{
		MockBukkit.unload();
	}

	@Test
	public void constructor_PropertiesSet()
	{
		assertSame(scoreboard, objective.getScoreboard());
		assertEquals("Objective", objective.getName());
		assertEquals("Objective", objective.getDisplayName());
		assertEquals("dummy", objective.getCriteria());
		assertNull(objective.getDisplaySlot());
	}
	
	@Test
	public void setDisplayName_AnyString_DisplayNameSet()
	{
		objective.setDisplayName("New name");
		assertEquals("New name", objective.getDisplayName(), "Display name not changed");
		assertEquals("Objective", objective.getName(), "Internal name was changed");
	}
	
	@Test
	public void unregister_ObjectiveWasRegistered_ObjectiveIsRemoved()
	{
		assumeNotNull("Objective was not registered", scoreboard.getObjective(objective.getName()));
		objective.unregister();
		assertNull(scoreboard.getObjective(objective.getName()), "Objective was not registered");
	}
	
	@Test
	public void getScore_Player_ReturnsNotNull()
	{
		PlayerMock player = server.addPlayer();
		assertNotNull(objective.getScore(player));
	}
	
	@Test
	public void getScore_SamePlayer_ReturnsSame()
	{
		PlayerMock player = server.addPlayer();
		Score score1 = objective.getScore(player);
		Score score2 = objective.getScore(player);
		assumeNotNull(score1);
		assertSame(score1, score2);
	}
	
	@Test
	public void getScore_String_ReturnsNotNull()
	{
		Score score = objective.getScore("The score");
		assertNotNull(score);
	}
	
	@Test
	public void getScore_SameString_ReturnsSame()
	{
		Score score1 = objective.getScore("The score");
		Score score2 = objective.getScore("The score");
		assertSame(score1, score2);
	}

}















