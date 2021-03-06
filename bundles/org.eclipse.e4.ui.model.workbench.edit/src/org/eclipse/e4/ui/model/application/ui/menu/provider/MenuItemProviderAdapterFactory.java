/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 */
package org.eclipse.e4.ui.model.application.ui.menu.provider;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.e4.ui.model.application.ui.menu.util.MenuAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MenuItemProviderAdapterFactory extends MenuAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuSeparatorItemProvider menuSeparatorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMenuSeparatorAdapter() {
		if (menuSeparatorItemProvider == null) {
			menuSeparatorItemProvider = new MenuSeparatorItemProvider(this);
		}

		return menuSeparatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MMenu} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemProvider menuItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MMenu}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMenuAdapter() {
		if (menuItemProvider == null) {
			menuItemProvider = new MenuItemProvider(this);
		}

		return menuItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MMenuContribution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuContributionItemProvider menuContributionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MMenuContribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMenuContributionAdapter() {
		if (menuContributionItemProvider == null) {
			menuContributionItemProvider = new MenuContributionItemProvider(this);
		}

		return menuContributionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopupMenuItemProvider popupMenuItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPopupMenuAdapter() {
		if (popupMenuItemProvider == null) {
			popupMenuItemProvider = new PopupMenuItemProvider(this);
		}

		return popupMenuItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectMenuItemItemProvider directMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDirectMenuItemAdapter() {
		if (directMenuItemItemProvider == null) {
			directMenuItemItemProvider = new DirectMenuItemItemProvider(this);
		}

		return directMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandledMenuItemItemProvider handledMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandledMenuItemAdapter() {
		if (handledMenuItemItemProvider == null) {
			handledMenuItemItemProvider = new HandledMenuItemItemProvider(this);
		}

		return handledMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolBarItemProvider toolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolBarAdapter() {
		if (toolBarItemProvider == null) {
			toolBarItemProvider = new ToolBarItemProvider(this);
		}

		return toolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MToolControl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolControlItemProvider toolControlItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MToolControl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolControlAdapter() {
		if (toolControlItemProvider == null) {
			toolControlItemProvider = new ToolControlItemProvider(this);
		}

		return toolControlItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandledToolItemItemProvider handledToolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandledToolItemAdapter() {
		if (handledToolItemItemProvider == null) {
			handledToolItemItemProvider = new HandledToolItemItemProvider(this);
		}

		return handledToolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectToolItemItemProvider directToolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDirectToolItemAdapter() {
		if (directToolItemItemProvider == null) {
			directToolItemItemProvider = new DirectToolItemItemProvider(this);
		}

		return directToolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarSeparator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolBarSeparatorItemProvider toolBarSeparatorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarSeparator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolBarSeparatorAdapter() {
		if (toolBarSeparatorItemProvider == null) {
			toolBarSeparatorItemProvider = new ToolBarSeparatorItemProvider(this);
		}

		return toolBarSeparatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedMenu} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderedMenuItemProvider renderedMenuItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedMenu}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderedMenuAdapter() {
		if (renderedMenuItemProvider == null) {
			renderedMenuItemProvider = new RenderedMenuItemProvider(this);
		}

		return renderedMenuItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderedToolBarItemProvider renderedToolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderedToolBarAdapter() {
		if (renderedToolBarItemProvider == null) {
			renderedToolBarItemProvider = new RenderedToolBarItemProvider(this);
		}

		return renderedToolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarContribution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolBarContributionItemProvider toolBarContributionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarContribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolBarContributionAdapter() {
		if (toolBarContributionItemProvider == null) {
			toolBarContributionItemProvider = new ToolBarContributionItemProvider(this);
		}

		return toolBarContributionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MTrimContribution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrimContributionItemProvider trimContributionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MTrimContribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTrimContributionAdapter() {
		if (trimContributionItemProvider == null) {
			trimContributionItemProvider = new TrimContributionItemProvider(this);
		}

		return trimContributionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderedMenuItemItemProvider renderedMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MRenderedMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderedMenuItemAdapter() {
		if (renderedMenuItemItemProvider == null) {
			renderedMenuItemItemProvider = new RenderedMenuItemItemProvider(this);
		}

		return renderedMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueToolItemItemProvider opaqueToolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueToolItemAdapter() {
		if (opaqueToolItemItemProvider == null) {
			opaqueToolItemItemProvider = new OpaqueToolItemItemProvider(this);
		}

		return opaqueToolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueMenuItemItemProvider opaqueMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueMenuItemAdapter() {
		if (opaqueMenuItemItemProvider == null) {
			opaqueMenuItemItemProvider = new OpaqueMenuItemItemProvider(this);
		}

		return opaqueMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenuSeparator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueMenuSeparatorItemProvider opaqueMenuSeparatorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenuSeparator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueMenuSeparatorAdapter() {
		if (opaqueMenuSeparatorItemProvider == null) {
			opaqueMenuSeparatorItemProvider = new OpaqueMenuSeparatorItemProvider(this);
		}

		return opaqueMenuSeparatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenu} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueMenuItemProvider opaqueMenuItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenu}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOpaqueMenuAdapter() {
		if (opaqueMenuItemProvider == null) {
			opaqueMenuItemProvider = new OpaqueMenuItemProvider(this);
		}

		return opaqueMenuItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (menuSeparatorItemProvider != null) menuSeparatorItemProvider.dispose();
		if (menuItemProvider != null) menuItemProvider.dispose();
		if (menuContributionItemProvider != null) menuContributionItemProvider.dispose();
		if (popupMenuItemProvider != null) popupMenuItemProvider.dispose();
		if (directMenuItemItemProvider != null) directMenuItemItemProvider.dispose();
		if (handledMenuItemItemProvider != null) handledMenuItemItemProvider.dispose();
		if (toolBarItemProvider != null) toolBarItemProvider.dispose();
		if (toolControlItemProvider != null) toolControlItemProvider.dispose();
		if (handledToolItemItemProvider != null) handledToolItemItemProvider.dispose();
		if (directToolItemItemProvider != null) directToolItemItemProvider.dispose();
		if (toolBarSeparatorItemProvider != null) toolBarSeparatorItemProvider.dispose();
		if (renderedMenuItemProvider != null) renderedMenuItemProvider.dispose();
		if (renderedToolBarItemProvider != null) renderedToolBarItemProvider.dispose();
		if (toolBarContributionItemProvider != null) toolBarContributionItemProvider.dispose();
		if (trimContributionItemProvider != null) trimContributionItemProvider.dispose();
		if (renderedMenuItemItemProvider != null) renderedMenuItemItemProvider.dispose();
		if (opaqueToolItemItemProvider != null) opaqueToolItemItemProvider.dispose();
		if (opaqueMenuItemItemProvider != null) opaqueMenuItemItemProvider.dispose();
		if (opaqueMenuSeparatorItemProvider != null) opaqueMenuSeparatorItemProvider.dispose();
		if (opaqueMenuItemProvider != null) opaqueMenuItemProvider.dispose();
	}

}
