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

import org.eclipse.swt.custom.CTabItem;

/**
 * @since 3.3
 * 
 */
public class CTabItemTooltipTextProperty extends WidgetStringValueProperty {
	String doGetStringValue(Object source) {
		return ((CTabItem) source).getText();
	}

	void doSetStringValue(Object source, String value) {
		((CTabItem) source).setText(value == null ? "" : (String) value); //$NON-NLS-1$
	}

	public String toString() {
		return "CTabItem.tooltipText <String>"; //$NON-NLS-1$
	}
}