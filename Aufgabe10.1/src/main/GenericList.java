package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GenericList<E> implements List<E>
{

	int firstEmptyIdx;
	E[] data;

	public GenericList()
	{
		data = (E[]) new Object[4];
		firstEmptyIdx = 0;
	}

	@Override
	public boolean add(E arg0)
	{
		int length = data.length;
		if (length <= firstEmptyIdx)
		{
			E[] tmp = (E[]) new Object[length * 2];
			System.arraycopy(data, 0, tmp, 0, length);
			data = tmp;
		}
		data[firstEmptyIdx] = arg0;
		firstEmptyIdx++;
		return true;
	}

	@Override
	public void add(int arg0, E arg1)
	{
		if (arg0 > firstEmptyIdx)
			throw new IndexOutOfBoundsException("add Index too big!");
		else if (arg0 == firstEmptyIdx)
			add(arg1);
		else
		{
			for (int i = firstEmptyIdx; i > arg0; i--)
			{
				data[i] = data[i - 1];
			}
			data[arg0] = arg1;
			firstEmptyIdx++;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0)
	{
		for (E elt : arg0)
		{
			add(elt);
		}
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1)
	{
		// Bonus (2 Punkte)
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear()
	{
		data = (E[]) new Object[data.length];
		// man könnte auch eine kürzere Länge nehmen aber so spare ich mir das rechnen
		// später :P
		firstEmptyIdx = 0;
	}

	@Override
	public boolean contains(Object arg0)
	{
		for (E elt : data)
		{
			if (Objects.equals(elt, arg0))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		for (Object elt : arg0)
		{
			if (!contains(elt))
				return false;
		}
		return true;
	}

	@Override
	public E get(int arg0)
	{
		if (arg0 >= firstEmptyIdx)
		{
			throw new IndexOutOfBoundsException("get Index too big!");
		}
		return data[arg0];
	}

	@Override
	public int indexOf(Object arg0)
	{
		for (int i = 0; i < firstEmptyIdx; i++)
		{
			if (Objects.equals(data[i], arg0))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		return (firstEmptyIdx == 0);
	}

	@Override
	public int lastIndexOf(Object arg0)
	{
		for (int i = firstEmptyIdx - 1; i >= 0; i--)
		{
			if (Objects.equals(data[i], arg0))
				return i;
		}
		return -1;
	}

	@Override
	public boolean remove(Object arg0)
	{
		int idx = indexOf(arg0);
		if (idx != -1)
			remove(indexOf(arg0));
		return true;
	}

	@Override
	public E remove(int arg0)
	{
		if (arg0 >= firstEmptyIdx)
			throw new IndexOutOfBoundsException("remove Index too big!");
		else
		{
			E tmp = data[arg0];
			for (int i = arg0; i < firstEmptyIdx; i++)
			{
				data[i] = data[i + 1];
			}
			firstEmptyIdx--;
			return tmp;
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		E[] olddata = data;
		Object[] tmp = arg0.toArray();
		for (int i = 0; i < arg0.size(); i++)
		{
			remove(tmp[i]);
		}
		return (!(Arrays.equals(olddata, data)));
	}

	@Override
	public boolean retainAll(Collection<?> arg0)
	{
		// Bonus
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int arg0, E arg1)
	{
		if (arg0 > firstEmptyIdx)
			throw new IndexOutOfBoundsException("set Index too big!");
		else if (arg0 == firstEmptyIdx)
			add(arg1);
		E tmp = data[arg0];
		data[arg0] = arg1;
		return tmp;
	}

	@Override
	public int size()
	{
		return firstEmptyIdx;
	}

	@Override
	public List<E> subList(int arg0, int arg1)
	{
		if (arg0 < 0 || arg1 > firstEmptyIdx || arg0 > arg1)
			throw new IndexOutOfBoundsException("illegal subList Index!");
		return Arrays.asList(data).subList(arg0, arg1);
	}

	@Override
	public Object[] toArray()
	{
		return Arrays.copyOf(data, firstEmptyIdx);
	}

	@Override
	public <T> T[] toArray(T[] arg0)
	{
		int ld = data.length;
		int l0 = arg0.length;
		if (ld == l0)
			return (T[]) toArray();
		else if (l0 < ld)
			return (T[]) Arrays.copyOf(data, ld);
		else
		{
			for (int i = 0; i < ld; i++)
			{
				arg0[i] = (T) data[i];
			}
			arg0[ld] = null;
			return arg0;
		}
	}

	////////////////////// You dont have to touch the following code ///////////////

	/**
	 * The GenericListIterator implements the ListIterator interface, which allows
	 * us to use Java Iterators, and all their features on the Generic list. For
	 * example you can use the foreach loop to iterate over all elements in a
	 * GenericList: for (E elt : list) See the printList Method in Generics.java for
	 * an example.
	 *
	 * @param <E> Type of the GnereicList elements.
	 */
	@SuppressWarnings("hiding")
	class GenericListIterator<E> implements ListIterator<E>
	{

		private GenericList<E> list;
		private int position;

		/**
		 * Creates a GenericListIterator at position 0 in the list.
		 * 
		 * @param list The list which is iterated.
		 */
		GenericListIterator(GenericList<E> list)
		{
			this.list = list;
			position = 0;
		}

		/**
		 * Creates a GenericListIterator at the given position in the list.
		 * 
		 * @param list     The list which is iterated.
		 * @param position Start position of the iterator.
		 */
		GenericListIterator(GenericList<E> list, int position)
		{
			this.list = list;
			this.position = position;
		}

		// For descriptions of the overwritten methods see the JavaDocs of the
		// @see(ListIterator) interface.
		@Override
		public void add(E arg0)
		{
			list.add(arg0);
		}

		@Override
		public boolean hasNext()
		{
			return position < list.size();
		}

		@Override
		public boolean hasPrevious()
		{
			return position > 0;
		}

		@Override
		public E next()
		{
			if (position >= list.size())
			{
				throw new NoSuchElementException();
			}
			E e = list.get(position);
			position += 1;
			return e;
		}

		@Override
		public int nextIndex()
		{
			return position;
		}

		@Override
		public E previous()
		{
			if (position <= 0)
			{
				throw new NoSuchElementException();
			}
			position -= 1;
			E e = list.get(position);
			return e;
		}

		@Override
		public int previousIndex()
		{
			return position - 1;
		}

		@Override
		public void remove()
		{
			list.remove(position);
		}

		@Override
		public void set(E arg0)
		{
			list.set(position, arg0);
		}

	}

	// The Iterator related methods just return a GenericListIterator of this list.
	// For detailed explanation see the documentation of the List and Iterator
	// interface.
	@Override
	public Iterator<E> iterator()
	{
		return listIterator();
	}

	@Override
	public ListIterator<E> listIterator()
	{
		return new GenericListIterator<E>(this);
	}

	@Override
	public ListIterator<E> listIterator(int arg0)
	{
		if (arg0 < 0 || arg0 >= firstEmptyIdx)
		{
			throw new IndexOutOfBoundsException(arg0);
		}
		return new GenericListIterator<E>(this, arg0);
	}

}
