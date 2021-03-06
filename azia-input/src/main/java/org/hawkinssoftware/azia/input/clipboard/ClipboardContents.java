/*
 * Copyright (c) 2011 HawkinsSoftware
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Byron Hawkins of HawkinsSoftware
 */
package org.hawkinssoftware.azia.input.clipboard;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * DOC comment task awaits.
 * 
 * @author Byron Hawkins
 */
public class ClipboardContents
{
	/**
	 * DOC comment task awaits.
	 * 
	 * @author Byron Hawkins
	 */
	public interface Provider
	{
		ClipboardContents getClipboardContents();
	}

	public static Provider createPlainTextProvider(String plainText)
	{
		return new PlainTextTransferable(plainText);
	}

	public enum Type
	{
		TEXT,
		IMAGE,
		FILES;
	}

	public final String text;
	public final Image image;
	public final List<File> files;

	public final Type type;
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

		if (hasImage())
		{
			type = Type.IMAGE;
		}
		else if (hasFiles())
		{
			type = Type.FILES;
		}
		else
		{
			type = Type.TEXT;
		}
	}

	private ClipboardContents(Transferable data, String plainText)
	{
		text = plainText;
		image = null;
		files = Collections.emptyList();

		contents = data;
		flavors = contents.getTransferDataFlavors();

		if (hasImage())
		{
			type = Type.IMAGE;
		}
		else if (hasFiles())
		{
			type = Type.FILES;
		}
		else
		{
			type = Type.TEXT;
		}
	}

	@SuppressWarnings("unchecked")
	private <DataType> DataType extractData(DataFlavor specificFlavor, String mimeType, Class<DataType> type, DataType defaultValue)
			throws UnsupportedFlavorException, IOException
	{
		if (contents.isDataFlavorSupported(specificFlavor))
		{
			return (DataType) contents.getTransferData(specificFlavor);
		}
		else
		{
			for (DataFlavor flavor : flavors)
			{
				if (flavor.getMimeType().startsWith(mimeType))
				{
					return (DataType) contents.getTransferData(flavor);
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
			if (!ClipboardImageComparator.getInstance().compare(image, other.image))
			{
				return false;
			}
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
		}
		else if (!text.equals(other.text))
		{
			return false;
		}

		if (flavors.length != other.flavors.length)
		{
			return false;
		}

		return true;
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

	private static class PlainTextTransferable implements Transferable, Provider
	{
		private static final DataFlavor[] DATA_FLAVORS = new DataFlavor[] { DataFlavor.stringFlavor };

		private final ClipboardContents data;

		public PlainTextTransferable(String plainText)
		{
			data = new ClipboardContents(this, plainText);
		}

		@Override
		public ClipboardContents getClipboardContents()
		{
			return data;
		}

		@Override
		public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
		{
			if (flavor.isFlavorTextType())
			{
				return data.text;
			}
			throw new UnsupportedFlavorException(flavor);
		}

		@Override
		public DataFlavor[] getTransferDataFlavors()
		{
			return DATA_FLAVORS;
		}

		@Override
		public boolean isDataFlavorSupported(DataFlavor flavor)
		{
			return flavor.isFlavorTextType();
		}
	}
}
