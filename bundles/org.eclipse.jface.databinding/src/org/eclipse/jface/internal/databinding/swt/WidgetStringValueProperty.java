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

/**
 * @since 3.3
 * 
 */
public abstract class WidgetStringValueProperty extends WidgetValueProperty {
	WidgetStringValueProperty(int event) {
		super(event, String.class);
	}

	WidgetStringValueProperty() {
		super(String.class);
	}

	public Object getValue(Object source) {
		return doGetStringValue(source);
	}

	public void setValue(Object source, Object value) {
		doSetStringValue(source, (String) value);
	}

	abstract String doGetStringValue(Object source);

	abstract void doSetStringValue(Object source, String value);
}