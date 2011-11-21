package org.hawkinssoftware.azia.input.clipboard;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.hawkinssoftware.rns.core.util.UnknownEnumConstantException;

public class ClipboardContentsMap<V>
{
	private final Map<ClipboardContents, V> map = new TreeMap<ClipboardContents, V>(new ContentsComparator());

	public V get(ClipboardContents key)
	{
		return map.get(key);
	}

	public void put(ClipboardContents key, V value)
	{
		map.put(key, value);
	}

	private static class ContentsComparator implements Comparator<ClipboardContents>
	{
		@Override
		public int compare(ClipboardContents first, ClipboardContents second)
		{
			if (first.equals(second))
			{
				return 0;
			}

			int comparison = first.type.compareTo(second.type);
			if (comparison != 0)
			{
				return comparison;
			}

			switch (first.type)
			{
				case TEXT:
					return first.text.compareTo(second.text);
				case FILES:
					comparison = (first.files.size() - second.files.size());
					if (comparison != 0)
					{
						return comparison;
					}
					for (int i = 0; i < first.files.size(); i++)
					{
						comparison = first.files.get(i).getAbsolutePath().compareTo(second.files.get(i).getAbsolutePath());
						if (comparison != 0)
						{
							return comparison;
						}
					}
					// very strange to ever get here... file sets should be equal, and initial branch should exit
					return 0;
				case IMAGE:
					return (first.image.hashCode() - second.image.hashCode());
				default:
					throw new UnknownEnumConstantException(first.type);
			}
		}
	}
}
