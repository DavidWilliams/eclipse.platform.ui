/*******************************************************************************
 * Copyright (c) 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchPreferences;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

/**
 * Internal class providing special access for configuring workbench windows.
 * <p>
 * Note that these objects are only available to the main application
 * (the plug-in that creates and owns the workbench).
 * </p>
 * <p>
 * This class is not intended to be instantiated or subclassed by clients.
 * </p>
 * 
 * @since 3.0
 */
public final class WorkbenchWindowConfigurer implements IWorkbenchWindowConfigurer {
	
	/**
	 * The workbench window associated with this configurer.
	 */
	private WorkbenchWindow window;

	/**
	 * Whether the workbench window should show the shortcut bar.
	 */
	private boolean showShortcutBar = true;
	
	/**
	 * Whether the workbench window should show the status line.
	 */
	private boolean showStatusLine = true;
	
	/**
	 * Whether the workbench window should show the main tool bar.
	 */
	private boolean showToolBar = true;
	
	/**
	 * Whether the workbench window should show the main menu bar.
	 */
	private boolean showMenuBar = true;
	
	/**
	 * Whether the workbench window should have a title bar.
	 */
	private boolean showTitleBar = true;

	/**
	 * Table to hold arbitrary key-data settings (key type: <code>String</code>,
	 * value type: <code>Object</code>).
	 * @see #setData
	 */
	private Map extraData = new HashMap(1);
	
	/**
	 * Creates a new workbench configurer.
	 * <p>
	 * This method is declared package-private. Clients obtain instances
	 * via {@link WorkbenchAdviser#getWindowConfigurer 
	 * WorkbenchAdviser.getWindowConfigurer}
	 * </p>
	 * 
	 * @param window the workbench window that this object configures
	 * @see WorkbenchAdviser#getWindowConfigurer
	 */
	WorkbenchWindowConfigurer(WorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.window = window;
	}

	/**
	 * Allows the configurer to initialize its state that
	 * depends on a Display existing.
	 */
	/* package */ void init() {
		IPreferenceStore store = WorkbenchPlugin.getDefault().getPreferenceStore();
		showMenuBar = store.getBoolean(IWorkbenchPreferences.SHOULD_SHOW_MENU_BAR);
		showShortcutBar = store.getBoolean(IWorkbenchPreferences.SHOULD_SHOW_SHORTCUT_BAR);
		showStatusLine = store.getBoolean(IWorkbenchPreferences.SHOULD_SHOW_STATUS_LINE);
		showTitleBar = store.getBoolean(IWorkbenchPreferences.SHOULD_SHOW_TITLE_BAR);
		showToolBar = store.getBoolean(IWorkbenchPreferences.SHOULD_SHOW_TOOL_BAR);
	}
	
	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getWindow
	 */
	public IWorkbenchWindow getWindow() {
		return window;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getWorkbenchConfigurer()
	 */
	public IWorkbenchConfigurer getWorkbenchConfigurer() {
		return Workbench.getInstance().getWorkbenchConfigurer();
	}
	
	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getTitle
	 */
	public String getTitle() {
		String title = window.getShell().getText();
		return title;
	}
	
	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setTitle
	 */
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException();
		}
		window.getShell().setText(title);
	}
	
	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getShowTitleBar
	 */
	public boolean getShowTitleBar() {
		return showTitleBar;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setShowTitleBar
	 */
	public void setShowTitleBar(boolean show) {
		showTitleBar = show;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getShowMenuBar
	 */
	public boolean getShowMenuBar() {
		return showMenuBar;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setShowMenuBar
	 */
	public void setShowMenuBar(boolean show) {
		showMenuBar = show;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getShowToolBar
	 */
	public boolean getShowToolBar() {
		return showToolBar;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setShowToolBar
	 */
	public void setShowToolBar(boolean show) {
		showToolBar = show;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getShowShortcutBar
	 */
	public boolean getShowShortcutBar() {
		return showShortcutBar;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setShowShortcutBar
	 */
	public void setShowShortcutBar(boolean show) {
		showShortcutBar = show;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getShowStatusLine
	 */
	public boolean getShowStatusLine() {
		return showStatusLine;
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setShowStatusLine
	 */
	public void setShowStatusLine(boolean show) {
		showStatusLine = show;
	}
	
	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getData
	 */
	public Object getData(String key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		return extraData.get(key);
	}

	/* (non-javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#setData
	 */
	public void setData(String key, Object data) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		if (data != null) {
			extraData.put(key, data);
		} else {
			extraData.remove(key);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getMenuManager()
	 */
	public IMenuManager getMenuManager() {
		return window.getMenuManager();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getCoolBarManager()
	 */
	public CoolBarManager getCoolBarManager() {
		return window.getCoolBarManager();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.IWorkbenchWindowConfigurer#getStatusLineManager()
	 */
	public IStatusLineManager getStatusLineManager() {
		return window.getStatusLineManager();
	}
}

