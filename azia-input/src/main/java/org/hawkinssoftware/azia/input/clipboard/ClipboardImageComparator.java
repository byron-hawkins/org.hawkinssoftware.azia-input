package org.hawkinssoftware.azia.input.clipboard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.ImageIcon;

import org.hawkinssoftware.azia.core.log.AziaLogging.Tag;
import org.hawkinssoftware.rns.core.log.Log;

class ClipboardImageComparator
{
	static ClipboardImageComparator getInstance()
	{
		return INSTANCE;
	}

	private static final ClipboardImageComparator INSTANCE = new ClipboardImageComparator();

	private final ByteArrayOutputStream firstOutputBuffer = new ByteArrayOutputStream();
	private final ByteArrayOutputStream secondOutputBuffer = new ByteArrayOutputStream();

	private final ObjectOutputStream firstOutput;
	private final ObjectOutputStream secondOutput;

	private final int[] firstSample = new int[4000];
	private final int[] secondSample = new int[4000];

	public ClipboardImageComparator()
	{
		try
		{
			firstOutput = new ObjectOutputStream(firstOutputBuffer);
			secondOutput = new ObjectOutputStream(secondOutputBuffer);
		}
		catch (IOException e)
		{
			throw new RuntimeException("Failed to construct the output buffers for byte comparison of images.", e);
		}
	}

	boolean compare(Image first, Image second)
	{
		if (first.getClass() != second.getClass())
		{
			return false;
		}
		if (first instanceof BufferedImage)
		{
			return compare((BufferedImage) first, (BufferedImage) second);
		}
		else
		{
			if ((first.getWidth(null) == second.getWidth(null)) && (first.getHeight(null) == second.getHeight(null)))
			{
				return compareBytes(first, second);
			}
		}
		return false;
	}

	private boolean compare(BufferedImage first, BufferedImage second)
	{
		if ((first.getWidth() != second.getWidth()) || (first.getHeight() != second.getHeight()))
		{
			return false;
		}

		int firstWidth = first.getWidth();
		int secondWidth = second.getWidth();
		int firstHeight = first.getHeight();
		int secondHeight = second.getHeight();

		Raster firstData = first.getData();
		Raster secondData = second.getData();

		Arrays.fill(firstSample, 0);
		Arrays.fill(secondSample, 0);
		int sampleWidth = Math.min(20, firstWidth);
		int sampleHeight = Math.min(20, first.getHeight());
		firstData.getPixels(0, 0, sampleWidth, sampleHeight, firstSample);
		secondData.getPixels(0, 0, sampleWidth, sampleHeight, secondSample);
		if (!Arrays.equals(firstSample, secondSample))
		{
			return false;
		}

		Arrays.fill(firstSample, 0);
		Arrays.fill(secondSample, 0);
		firstData.getPixels(firstWidth - sampleWidth, firstHeight - sampleHeight, sampleWidth, sampleHeight, firstSample);
		secondData.getPixels(secondWidth - sampleWidth, secondHeight - sampleHeight, sampleWidth, sampleHeight, secondSample);
		return Arrays.equals(firstSample, secondSample);
	}

	// TODO: this might be leaking, though rarely used.
	private boolean compareBytes(Image first, Image second)
	{
		try
		{
			firstOutput.writeObject(new ImageIcon(first));
			secondOutput.writeObject(new ImageIcon(second));

			byte[] firstBytes = firstOutputBuffer.toByteArray();
			byte[] secondBytes = secondOutputBuffer.toByteArray();

			firstOutput.flush();
			secondOutput.flush();
			firstOutputBuffer.reset();
			secondOutputBuffer.reset();

			return Arrays.equals(firstBytes, secondBytes);
		}
		catch (IOException e)
		{
			Log.out(Tag.WARNING, e, "Failed to compare images by byte content.");
			return false;
		}
	}
}
