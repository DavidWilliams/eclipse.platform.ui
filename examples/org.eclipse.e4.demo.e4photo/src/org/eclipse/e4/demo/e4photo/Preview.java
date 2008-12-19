package org.eclipse.e4.demo.e4photo;

import java.io.InputStream;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.e4.workbench.ui.behaviors.IHasInput;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class Preview implements IHasInput {

	private static int topImageMargin = 16;
	private static int bottomImageMargin = 16;
	private static int frameWidth = 6;

	private final Composite parent;
	private Image currentImage;

	private IObservableValue parentSize;
	private IObservableValue inputFile;
	private IObservableValue rawImageData;
	private IObservableValue scaledImageData;
	private final Realm bgRealm;
	private Color borderColor;
	
	public Preview(final Composite parentComposite, Realm backgroundRealm) {
		this.parent = parentComposite;
		parent.setData("id", "preview");

		this.bgRealm = backgroundRealm;
		this.inputFile = new WritableValue(bgRealm);
		this.rawImageData = new ComputedValue(bgRealm) {
			protected Object calculate() {
				IFile file = (IFile) inputFile.getValue();
				if (file == null) {
					return null;
				}
				InputStream contents;
				try {
					contents = file.getContents();
					try {
						return new ImageData(contents);
					} finally {
						contents.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};
		this.parentSize = new WritableValue(bgRealm);
		this.scaledImageData = new ComputedValue(bgRealm) {
			protected Object calculate() {
				ImageData rawData = (ImageData) rawImageData.getValue();
				Point maxSize = (Point) parentSize.getValue();
				if (rawData == null || maxSize == null) {
					return null;
				}
				Point targetSize = getBestSize(rawData.width, rawData.height,
						maxSize.x, maxSize.y);
				return rawData.scaledTo(targetSize.x, targetSize.y);
			}
		};
		scaledImageData.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				if (currentImage != null) {
					currentImage.dispose();
					currentImage = null;
				}
				ImageData imageData = (ImageData) scaledImageData.getValue();
				currentImage = imageData == null ? null : new Image(
						parent.getDisplay(), imageData);
				parent.getDisplay().asyncExec(new Runnable() {
					public void run() {
						parent.redraw();
					}
				});
			}
		});
		parent.setLayout(new FillLayout());
		parent.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (e.gc.isDisposed())
					return;
				
				e.gc.fillRectangle(new Rectangle(e.x, e.y, e.width, e.height));
				Image i = currentImage;
				if (i != null && !i.isDisposed()) {
					Rectangle imageBounds = currentImage.getBounds();
					int x = (parent.getBounds().width - imageBounds.width) / 2;
					int y = bottomImageMargin;
					if(borderColor == null)
						borderColor = new Color(e.gc.getDevice(), 229, 229, 229);
					Color lastBackground = e.gc.getBackground();
					e.gc.setBackground(borderColor);
					e.gc.fillRoundRectangle(x, y, imageBounds.width + (frameWidth * 2), imageBounds.height + (frameWidth * 2), frameWidth, frameWidth);
					e.gc.setBackground(lastBackground);
					e.gc.drawImage(i, x + frameWidth, y + frameWidth);
				}
			}
		});
		parent.addControlListener(new ControlListener() {
			public void controlMoved(ControlEvent e) {
			}

			public void controlResized(ControlEvent e) {
				final Point newSize = parent.getSize();
				bgRealm.asyncExec(new Runnable() {
					public void run() {
						parentSize.setValue(newSize);
					}
				});
			}
		});
	}

	public Class getInputType() {
		return IFile.class;
	}

	public void setInput(final Object input) {
		bgRealm.asyncExec(new Runnable() {
			public void run() {
				inputFile.setValue(input);
			}
		});
	}

	private Point getBestSize(int originalX, int originalY, int maxX, int maxY) {
		double widthRatio = (double) originalX / (double) maxX;
		double heightRatio = (double) originalY / (double) maxY;

		double bestRatio = widthRatio > heightRatio ? widthRatio : heightRatio;

		int newWidth = (int) ((double) originalX / bestRatio) - (frameWidth * 2);
		int newHeight = (int) ((double) originalY / bestRatio)  - (topImageMargin + bottomImageMargin + (frameWidth * 2));

		return new Point(newWidth, newHeight);
	}

}