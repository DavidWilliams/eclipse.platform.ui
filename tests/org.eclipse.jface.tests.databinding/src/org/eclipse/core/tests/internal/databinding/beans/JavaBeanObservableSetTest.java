/*******************************************************************************
 * Copyright (c) 2007-2008 Brad Reynolds and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Brad Reynolds - initial API and implementation
 *     Matthew Hall - bugs 221351, 213145, 244098, 246103, 194734
 ******************************************************************************/

package org.eclipse.core.tests.internal.databinding.beans;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.IBeanObservable;
import org.eclipse.core.databinding.beans.IBeanProperty;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.jface.databinding.conformance.MutableObservableSetContractTest;
import org.eclipse.jface.databinding.conformance.delegate.AbstractObservableCollectionContractDelegate;
import org.eclipse.jface.databinding.conformance.util.ChangeEventTracker;
import org.eclipse.jface.databinding.conformance.util.CurrentRealm;
import org.eclipse.jface.databinding.conformance.util.SetChangeEventTracker;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;

/**
 * @since 3.3
 */
public class JavaBeanObservableSetTest extends TestCase {
	private IObservableSet observableSet;
	private IBeanObservable beanObservable;
	private Bean bean;
	private PropertyDescriptor propertyDescriptor;
	private String propertyName;
	private SetChangeListener listener;

	protected void setUp() throws Exception {
		bean = new Bean();
		propertyName = "set";
		propertyDescriptor = ((IBeanProperty) BeanProperties.set(
				Bean.class, propertyName)).getPropertyDescriptor();

		observableSet = BeansObservables
				.observeSet(SWTObservables.getRealm(Display.getDefault()),
						bean, propertyName, Bean.class);
		beanObservable = (IBeanObservable) observableSet;
		listener = new SetChangeListener();
	}

	public void testGetObserved() throws Exception {
		assertEquals(bean, beanObservable.getObserved());
	}

	public void testGetPropertyDescriptor() throws Exception {
		assertEquals(propertyDescriptor, beanObservable.getPropertyDescriptor());
	}
	
	public void testGetElementType() throws Exception {
		assertEquals(Bean.class, observableSet.getElementType());
	}
	
	public void testRegistersListenerAfterFirstListenerIsAdded() throws Exception {
		assertFalse(bean.changeSupport.hasListeners(propertyName));
		observableSet.addSetChangeListener(new SetChangeListener());
		assertTrue(bean.changeSupport.hasListeners(propertyName));
	}
		
    public void testRemovesListenerAfterLastListenerIsRemoved() throws Exception {
		observableSet.addSetChangeListener(listener);
		
		assertTrue(bean.changeSupport.hasListeners(propertyName));
		observableSet.removeSetChangeListener(listener);
		assertFalse(bean.changeSupport.hasListeners(propertyName));
	}
	
	public void testFiresChangeEvents() throws Exception {
		observableSet.addSetChangeListener(listener);
		assertEquals(0, listener.count);
		bean.setSet(new HashSet(Arrays.asList(new String[] {"1"})));
		assertEquals(1, listener.count);
	}

	public void testConstructor_RegisterListeners() throws Exception {
		bean = new Bean();
		observableSet = BeansObservables.observeSet(new CurrentRealm(true), bean,
				propertyName);
		assertFalse(bean.hasListeners(propertyName));
		ChangeEventTracker.observe(observableSet);
		assertTrue(bean.hasListeners(propertyName));
	}

	public void testConstructor_SkipsRegisterListeners() throws Exception {
		bean = new Bean();

		observableSet = PojoObservables.observeSet(new CurrentRealm(true),
				bean, propertyName);
		assertFalse(bean.hasListeners(propertyName));
		ChangeEventTracker.observe(observableSet);
		assertFalse(bean.hasListeners(propertyName));
	}

	public void testSetBeanProperty_CorrectForNullOldAndNewValues() {
		// The java bean spec allows the old and new values in a
		// PropertyChangeEvent to be null, which indicates that an unknown
		// change occured.

		// This test ensures that JavaBeanObservableValue fires the correct
		// value diff even if the bean implementor is lazy :-P

		Bean bean = new AnnoyingBean();
		bean.setSet(Collections.singleton("old"));
		IObservableSet observable = BeansObservables.observeSet(
				new CurrentRealm(true), bean, "set");
		SetChangeEventTracker tracker = SetChangeEventTracker
				.observe(observable);
		bean.setSet(Collections.singleton("new"));
		assertEquals(1, tracker.count);
		assertEquals(Collections.singleton("old"), tracker.event.diff
				.getRemovals());
		assertEquals(Collections.singleton("new"), tracker.event.diff
				.getAdditions());
	}

	static class SetChangeListener implements ISetChangeListener {
		int count;
		public void handleSetChange(SetChangeEvent event) {
			count++;
		}
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(JavaBeanObservableSetTest.class.getName());
		suite.addTestSuite(JavaBeanObservableSetTest.class);
		suite.addTest(MutableObservableSetContractTest.suite(new Delegate()));
		return suite;
	}

	private static class Delegate extends
			AbstractObservableCollectionContractDelegate {
		public IObservableCollection createObservableCollection(Realm realm,
				int elementCount) {
			Bean bean = new Bean();
			String propertyName = "set";

			IObservableSet set = BeansObservables.observeSet(realm, bean,
					propertyName, String.class);
			for (int i = 0; i < elementCount; i++)
				set.add(createElement(set));
			return set;
		}

		public Object createElement(IObservableCollection collection) {
			return new Object();
		}

		public Object getElementType(IObservableCollection collection) {
			return String.class;
		}

		public void change(IObservable observable) {
			IObservableSet set = (IObservableSet) observable;
			set.add(createElement(set));
		}
	}
}