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

package org.eclipse.core.databinding.property.set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.map.IMapProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;

/**
 * Interface for set-typed properties
 * 
 * @since 1.2
 * @noimplement This interface is not intended to be implemented by clients.
 *              Clients should instead subclass one of the classes that
 *              implement this interface. Note that direct implementers of this
 *              interface outside of the framework will be broken in future
 *              releases when methods are added to this interface.
 * @see SetProperty
 * @see SimpleSetProperty
 */
public interface ISetProperty extends IProperty {
	/**
	 * Returns an observable set observing this set property on the given
	 * property source
	 * 
	 * @param source
	 *            the property source
	 * @return an observable set observing this set property on the given
	 *         property source
	 */
	public IObservableSet observeSet(Object source);

	/**
	 * Returns an observable set observing this set property on the given
	 * property source
	 * 
	 * @param realm
	 *            the observable's realm
	 * @param source
	 *            the property source
	 * @return an observable set observing this set property on the given
	 *         property source
	 */
	public IObservableSet observeSet(Realm realm, Object source);

	/**
	 * Returns an observable set on the master observable's realm which tracks
	 * this property of the current value of <code>master</code>.
	 * 
	 * @param master
	 *            the master observable
	 * @return an observable set on the given realm which tracks this property
	 *         of the current value of <code>master</code>.
	 */
	public IObservableSet observeDetailSet(IObservableValue master);

	/**
	 * Returns the nested combination of this property and the specified detail
	 * value property. Note that because this property is a projection of value
	 * properties over a set, the only modifications supported are through the
	 * {@link IObservableMap#put(Object, Object)} and
	 * {@link IObservableMap#putAll(java.util.Map)} methods. In the latter case,
	 * this property does not put entries for keys not already in the master key
	 * set. Modifications made through the returned property are delegated to
	 * the detail property, using the corresponding set element from the master
	 * property as the source.
	 * 
	 * @param detailValues
	 *            the detail property
	 * @return the nested combination of the master set and detail value
	 *         properties
	 */
	public IMapProperty chain(IValueProperty detailValues);
}