package be.seeseemelk.mockbukkit.scoreboard;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardManagerMockTest
{
	private ScoreboardManager manager;

	@BeforeEach
	public void setUp() throws Exception
	{
		manager = new ScoreboardManagerMock();
	}

	@Test
	public void getMainScoreboard_NotNull()
	{
		assertNotNull(manager.getMainScoreboard());
	}
	
	@Test
	public void getMainScoreboard_MultipleCalls_ReturnsSame()
	{
		Scoreboard scoreboardA = manager.getMainScoreboard();
		Scoreboard scoreboardB = manager.getMainScoreboard();
		assertSame(scoreboardA, scoreboardB);
	}
	
	@Test
	public void getNewScoreboard_NotNull()
	{
		assertNotNull(manager.getNewScoreboard());
	}
	
	@Test
	public void getNewScoreboard_MultipleCalls_ReturnsDifferentInstances()
	{
		Scoreboard scoreboardA = manager.getNewScoreboard();
		Scoreboard scoreboardB = manager.getNewScoreboard();
		assertNotSame(scoreboardA, scoreboardB);
	}

}
