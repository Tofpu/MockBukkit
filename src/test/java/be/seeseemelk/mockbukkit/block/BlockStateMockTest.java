package be.seeseemelk.mockbukkit.block;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class BlockStateMockTest
{
	@Test
	public void getData_Default_Null()
	{
		BlockStateMock state = new BlockStateMock();
		assertNull(state.getData());
	}
}
