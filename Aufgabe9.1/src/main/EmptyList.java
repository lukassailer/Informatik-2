package main;

public class EmptyList implements IntegerList
{

	public EmptyList()
	{
		// :-)
	}

	@Override
	public void print()
	{
		// nix
	}

	@Override
	public int length()
	{
		return 0;
	}

	@Override
	public IntegerList append(int element)
	{
		return new Pair(element, this);
	}

	@Override
	public int get(int index) throws Exception
	{
		throw new Exception("index too big!");
	}

	@Override
	public IntegerList insert(int element, int index) throws Exception
	{
		if (index == 0)
			return new Pair(element, this);
		throw new Exception("index too big!");
	}

	@Override
	public IntegerList deleteElement(int index) throws Exception
	{
		throw new Exception("List is already empty!");
	}

	@Override
	public IntegerList reversed()
	{
		return this;
	}

	@Override
	public IntegerList extend(IntegerList other)
	{
		return other;
	}

	@Override
	public int min()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isSorted()
	{
		return true;
	}

}
