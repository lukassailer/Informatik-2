package main;

public class Pair implements IntegerList
{
	private int element;
	private IntegerList rest;

	public Pair(int element, IntegerList rest)
	{
		this.element = element;
		this.rest = rest;
	}

	@Override
	public void print()
	{
		System.out.println(element);
		rest.print();
	}

	@Override
	public int length()
	{
		return 1 + rest.length();
	}

	@Override
	public IntegerList append(int element)
	{
		return new Pair(this.element, rest.append(element));
	}

	@Override
	public int get(int index) throws Exception
	{
		if (index == 0)
			return element;
		return rest.get(index - 1);
	}

	@Override
	public IntegerList insert(int element, int index) throws Exception
	{
		if (index == 0)
			return new Pair(element, new Pair(this.element, rest));
		return new Pair(this.element, rest.insert(element, index - 1));
	}

	@Override
	public IntegerList deleteElement(int index) throws Exception
	{
		if (index == 0)
			return rest;
		return new Pair(element, rest.deleteElement(index - 1));
	}

	@Override
	public IntegerList reversed()
	{
		return rest.reversed().append(element);
	}

	@Override
	public IntegerList extend(IntegerList other)
	{
		return new Pair(element, rest.extend(other));
	}

	@Override
	public int min()
	{
		if (element <= rest.min())
			return element;
		return rest.min();
	}

	@Override
	public boolean isSorted()
	{
		if (element == min())
			return rest.isSorted();
		return false;
	}

}
