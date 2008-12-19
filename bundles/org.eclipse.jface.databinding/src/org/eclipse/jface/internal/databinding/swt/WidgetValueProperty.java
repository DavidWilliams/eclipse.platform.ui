/*******************************************************************************
 * Copyright (c) 2008 Matthew Hall and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Hall - initial API and implementation (bug 194734)
 ******************************************************************************/

package org.eclipse.jface.internal.databinding.swt;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.value.IValuePropertyChangeListener;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.core.databinding.property.value.ValuePropertyChangeEvent;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

abstract class WidgetValueProperty extends SimpleValueProperty {
	private int[] events;

	WidgetValueProperty(Object valueType) {
		this(null, valueType);
	}

	WidgetValueProperty(int event, Object valueType) {
		this(new int[] { event }, valueType);
	}

	WidgetValueProperty(int[] events, Object valueType) {
		super(valueType);
		this.events = events;
	}

	public IObservableValue observeValue(Object source) {
		Widget widget = (Widget) source;
		return observeValue(SWTObservables.getRealm(widget.getDisplay()),
				widget);
	}

	public INativePropertyListener adaptListener(
			IValuePropertyChangeListener listener) {
		return new WidgetListener(listener);
	}

	public void addListener(Object source, INativePropertyListener listener) {
		if (events != null) {
			for (int i = 0; i < events.length; i++) {
				int event = events[i];
				if (event != SWT.None) {
					((Widget) source).addListener(event, (Listener) listener);
				}
			}
		}
	}

	public void removeListener(Object source, INativePropertyListener listener) {
		if (events != null) {
			Widget widget = (Widget) source;
			if (!widget.isDisposed()) {
				for (int i = 0; i < events.length; i++) {
					int event = events[i];
					if (event != SWT.None)
						widget.removeListener(event, (Listener) listener);
				}
			}
		}
	}

	private class WidgetListener implements INativePropertyListener, Listener {
		private final IValuePropertyChangeListener listener;

		protected WidgetListener(IValuePropertyChangeListener listener) {
			this.listener = listener;
		}

		public void handleEvent(Event event) {
			listener.handleValuePropertyChange(new ValuePropertyChangeEvent(
					event.widget, WidgetValueProperty.this, null));
		}
	}
}