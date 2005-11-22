/******************************************************************************* * Copyright (c) 2005 IBM Corporation and others. * All rights reserved. This program and the accompanying materials * are made available under the terms of the Eclipse Public License v1.0 * which accompanies this distribution, and is available at * http://www.eclipse.org/legal/epl-v10.html * * Contributors: *     IBM Corporation - initial API and implementation ******************************************************************************/package org.eclipse.jface.menus;import org.eclipse.core.commands.common.NotDefinedException;import org.eclipse.jface.util.Util;/** * <p> * <strong>EXPERIMENTAL</strong>. This class or interface has been added as * part of a work in progress. There is a guarantee neither that this API will * work nor that it will remain the same. Please do not use this API without * consulting with the Platform/UI team. * </p> *  * @since 3.2 */public final class SWidget extends MenuElement {	/**	 * The class that will contribute widgets to the menu; never	 * <code>null</code>.	 */	private IWidget thirdPartyCode;	/**	 * Constructs a new instance of <code>SWidget</code>.	 * 	 * @param id	 *            The identifier of the widget to create; must not be	 *            <code>null</code>	 */	SWidget(final String id) {		super(id);	}	/**	 * Adds a listener to this widget that will be notified when this widget	 * state changes.	 * 	 * @param listener	 *            The listener to be added; must not be <code>null</code>.	 */	public final void addListener(final IWidgetListener listener) {		addListenerObject(listener);	}	/**	 * <p>	 * Defines this widget by providing the class defining the widget. The	 * locations are optional. The defined property automatically becomes	 * <code>true</code>.	 * </p>	 * 	 * @param widget	 *            The class that is called to contribute widgets to the given	 *            locations; must not be <code>null</code>.	 * @param locations	 *            The locations in which this item will appear; may be	 *            <code>null</code> or empty.	 */	public final void define(final IWidget widget, final SLocation[] locations) {		if (widget == null) {			throw new NullPointerException(					"A widget needs a class to contribute the widgets"); //$NON-NLS-1$		}		WidgetEvent event = null;		if (isListenerAttached()) {			final boolean thirdPartyCodeChanged = !Util.equals(					this.thirdPartyCode, widget);			final boolean locationsChanged = !Util.equals(this.locations,					locations);			final boolean definedChanged = !this.defined;			event = new WidgetEvent(this, thirdPartyCodeChanged,					locationsChanged, definedChanged, false);		}		this.thirdPartyCode = widget;		this.locations = locations;		this.defined = true;		fireWidgetChanged(event);	}	/**	 * Notifies listeners to this group that it has changed visibility.	 */	protected final void fireVisibleChanged() {		if (isListenerAttached()) {			final WidgetEvent event = new WidgetEvent(this, false, false,					false, true);			fireWidgetChanged(event);		}	}	/**	 * Notifies listeners to this widget that it has changed in some way.	 * 	 * @param event	 *            The event to fire; may be <code>null</code>.	 */	private final void fireWidgetChanged(final WidgetEvent event) {		if (event == null) {			return;		}		final Object[] listeners = getListeners();		for (int i = 0; i < listeners.length; i++) {			final IWidgetListener listener = (IWidgetListener) listeners[i];			listener.widgetChanged(event);		}	}	/**	 * Returns the class providing the widgets for this menu element.	 * 	 * @return The widget for this menu element; never <code>null</code>.	 * @throws NotDefinedException	 *             If the handle is not currently defined.	 */	public final IWidget getWidget() throws NotDefinedException {		if (!isDefined()) {			throw new NotDefinedException(					"Cannot get the widget class from an undefined widget"); //$NON-NLS-1$		}		return thirdPartyCode;	}	/**	 * Removes a listener from this widget.	 * 	 * @param listener	 *            The listener to be removed; must not be <code>null</code>.	 */	public final void removeListener(final IWidgetListener listener) {		removeListenerObject(listener);	}	/**	 * The string representation of this widget -- for debugging purposes only.	 * This string should not be shown to an end user.	 * 	 * @return The string representation; never <code>null</code>.	 */	public final String toString() {		if (string == null) {			final StringBuffer stringBuffer = new StringBuffer();			stringBuffer.append("SWidget("); //$NON-NLS-1$			stringBuffer.append(id);			stringBuffer.append(',');			stringBuffer.append(locations);			stringBuffer.append(',');			try {				stringBuffer.append(thirdPartyCode);			} catch (final Exception e) {				// A bogus toString() in third-party code. Ignore.				stringBuffer.append(e.getClass().getName());			}			stringBuffer.append(',');			stringBuffer.append(defined);			stringBuffer.append(')');			string = stringBuffer.toString();		}		return string;	}	/**	 * Makes this widget become undefined. This has the side effect of changing	 * the locations and widget to <code>null</code>. Notification is sent to	 * all listeners.	 */	public final void undefine() {		string = null;		WidgetEvent event = null;		if (isListenerAttached()) {			final boolean thirdPartyCodeChanged = thirdPartyCode != null;			final boolean locationsChanged = locations != null;			final boolean definedChanged = this.defined;			event = new WidgetEvent(this, thirdPartyCodeChanged,					locationsChanged, definedChanged, false);		}		defined = false;		thirdPartyCode = null;		locations = null;		fireWidgetChanged(event);	}}