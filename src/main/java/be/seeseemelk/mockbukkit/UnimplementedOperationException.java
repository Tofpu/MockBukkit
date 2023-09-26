package be.seeseemelk.mockbukkit;

import org.opentest4j.TestAbortedException;

public class UnimplementedOperationException extends TestAbortedException
{
	private static final long serialVersionUID = 1L;

	public UnimplementedOperationException()
	{
		super("Not implemented");
	}
	
	public UnimplementedOperationException(String message)
	{
		super(message);
	}
}
