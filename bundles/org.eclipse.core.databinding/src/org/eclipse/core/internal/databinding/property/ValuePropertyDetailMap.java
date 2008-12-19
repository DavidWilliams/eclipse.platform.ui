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

package org.eclipse.core.internal.databinding.property;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.map.IMapProperty;
import org.eclipse.core.databinding.property.map.MapProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;

/**
 * @since 3.3
 * 
 */
public class ValuePropertyDetailMap extends MapProperty {
	private final IValueProperty masterProperty;
	private final IMapProperty detailProperty;

	/**
	 * @param masterProperty
	 * @param detailProperty
	 */
	public ValuePropertyDetailMap(IValueProperty masterProperty,
			IMapProperty detailProperty) {
		this.masterProperty = masterProperty;
		this.detailProperty = detailProperty;
	}

	public IObservableMap observeMap(Realm realm, Object source) {
		IObservableValue master = masterProperty.observeValue(realm, source);
		return detailProperty.observeDetailMap(master);
	}

	public IObservableMap observeDetailMap(IObservableValue master) {
		IObservableValue masterValue = masterProperty
				.observeDetailValue(master);
		return detailProperty.observeDetailMap(masterValue);
	}

	public String toString() {
		return masterProperty + " => " + detailProperty; //$NON-NLS-1$
	}
}