package main;

public class EmptyTree implements SortedFloatTree
{

	public EmptyTree()
	{
	}

	@Override
	public String asString()
	{
		return "";
	}

	@Override
	public int depth()
	{
		return 0;
	}

	@Override
	public int nodeCount()
	{
		return 0;
	}

	@Override
	public boolean exists(float element)
	{
		return false;
	}

	@Override
	public SortedFloatTree insert(float element)
	{
		return new Node(element, this, this);
	}

}
