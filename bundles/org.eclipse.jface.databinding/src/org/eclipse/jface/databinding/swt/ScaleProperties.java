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

package org.eclipse.jface.databinding.swt;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.internal.databinding.swt.ScaleMaximumProperty;
import org.eclipse.jface.internal.databinding.swt.ScaleMinimumProperty;
import org.eclipse.jface.internal.databinding.swt.ScaleSelectionProperty;

/**
 * A factory for creating properties of SWT Scales.
 * 
 * @since 1.3
 */
public class ScaleProperties {
	/**
	 * Returns a value property for the selected value of a SWT Scale.
	 * 
	 * @return a value property for the selected value of a SWT Scale.
	 */
	public static IValueProperty selection() {
		return new ScaleSelectionProperty();
	}

	/**
	 * Returns a value property for the minimum value of a SWT Scale.
	 * 
	 * @return a value property for the minimum value of a SWT Scale.
	 */
	public static IValueProperty minimum() {
		return new ScaleMinimumProperty();
	}

	/**
	 * Returns a value property for the maximum value of a SWT Scale.
	 * 
	 * @return a value property for the maximum value of a SWT Scale.
	 */
	public static IValueProperty maximum() {
		return new ScaleMaximumProperty();
	}
}