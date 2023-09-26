package be.seeseemelk.mockbukkit.scoreboard;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ScoreMockTest
{
	private ServerMock server;
	private ScoreboardMock scoreboard;
	private ObjectiveMock objective;
	private ScoreMock score;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		server = MockBukkit.mock();
		scoreboard = server.getScoreboardManager().getNewScoreboard();
		objective = scoreboard.registerNewObjective("Objective", "dummy");
		score = objective.getScore("Entry");
	}
	
	@AfterEach
	public void tearDown() throws Exception
	{
		MockBukkit.unload();
	}
	
	@Test
	public void getEntry_ReturnsEntry()
	{
		assertEquals("Entry", score.getEntry());
	}
	
	@Test
	public void getObjective_ReturnsParentObjective()
	{
		assertSame(objective, score.getObjective());
	}
	
	@Test
	public void getScore_ObjectiveRegisteredButNoScoreSet_ReturnsZero()
	{
		assertEquals(0, score.getScore());
	}
	
	@Test
	public void getScore_ObjectiveUnregistered_ThrowsError()
	{
		Assertions.assertThrows(IllegalStateException.class, () -> {
			objective.unregister();
			score.getScore();
		});
	}
	
	@Test
	public void getScore_ObjectiveRegisteredAndScoreSet_ReturnsNumber()
	{
		score.setScore(5);
		assertEquals(5, score.getScore());
	}
	
	@Test
	public void getPlayer_PlayerSet_ReturnsPlayer()
	{
		PlayerMock player = server.addPlayer();
		score.setPlayer(player);
		assertSame(player, score.getPlayer());
	}
	
	@Test
	public void getScoreboard_ReturnsScoreboard()
	{
		assertSame(scoreboard, score.getScoreboard());
	}
	
}
