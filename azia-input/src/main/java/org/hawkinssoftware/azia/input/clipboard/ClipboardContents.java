package org.hawkinssoftware.azia.input.clipboard;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ClipboardContents
{
	public interface Provider
	{
		ClipboardContents getClipboardContents();
	}
	
	public final String text;
	public final Image image;
	public final List<File> files;

	public final DataFlavor[] flavors;

	final Transferable contents;

	@SuppressWarnings("unchecked")
	public ClipboardContents(Transferable contents) throws UnsupportedFlavorException, IOException
	{
		this.contents = contents;
		this.flavors = contents.getTransferDataFlavors();

		image = extractData(DataFlavor.imageFlavor, "image", Image.class, null);
		files = extractData(DataFlavor.javaFileListFlavor, "file", List.class, Collections.emptyList());
		text = extractData(DataFlavor.stringFlavor, "text", String.class, "");
	}

	@SuppressWarnings("unchecked")
	private <Type> Type extractData(DataFlavor specificFlavor, String mimeType, Class<Type> type, Type defaultValue)
			throws UnsupportedFlavorException, IOException
	{
		if (contents.isDataFlavorSupported(specificFlavor))
		{
			return (Type) contents.getTransferData(specificFlavor);
		}
		else
		{
			for (DataFlavor flavor : flavors)
			{
				if (flavor.getMimeType().startsWith(mimeType))
				{
					return (Type) contents.getTransferData(flavor);
				}
			}
		}
		return defaultValue;
	}

	public Object getData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
	{
		return contents.getTransferData(flavor);
	}

	public boolean hasImage()
	{
		return image != null;
	}

	public boolean hasFiles()
	{
		return !files.isEmpty();
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof ClipboardContents))
		{
			return false;
		}

		ClipboardContents other = (ClipboardContents) o;

		if ((hasImage() != other.hasImage()) || (hasFiles() != other.hasFiles()))
		{
			return false;
		}

		if (hasImage())
		{
			return ClipboardImageComparator.getInstance().compare(image, other.image);
		}

		if (hasFiles())
		{
			if (files.size() != other.files.size())
			{
				return false;
			}

			for (int i = 0; i < files.size(); i++)
			{
				if (!files.get(i).getAbsolutePath().equals(other.files.get(i).getAbsolutePath()))
				{
					return false;
				}
			}
			
			return true;
		}

		return text.equals(other.text);
	}
	
	public String getSummary()
	{
		if (image != null)
		{
			return String.format("Image %dx%d (%s)", image.getWidth(null), image.getHeight(null), text);
		}

		if (!files.isEmpty())
		{
			return String.format("%d files", files.size());
		}

		return text;
	}

	@Override
	public String toString()
	{
		return getSummary();
	}

}
