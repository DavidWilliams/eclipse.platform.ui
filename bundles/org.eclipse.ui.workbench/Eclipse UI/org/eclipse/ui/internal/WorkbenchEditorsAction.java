/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


package org.eclipse.ui.internal;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.internal.dialogs.WorkbenchEditorsDialog;

/**
 * Implements a action to open a dialog showing all open editors
 * and the recent closed editors.
 */
public class WorkbenchEditorsAction extends Action {

	IWorkbenchWindow window;

	/**
	 * Constructor for NavigateWorkbenchAction.
	 * @param text
	 */
	public WorkbenchEditorsAction(IWorkbenchWindow window) {
		super(WorkbenchMessages.getString("WorkbenchEditorsAction.label")); //$NON-NLS-1$
		this.window = window;
		WorkbenchHelp.setHelp(this, IHelpContextIds.WORKBENCH_EDITORS_ACTION);
	}
	public void run() {
		WorkbenchPage page = (WorkbenchPage)window.getActivePage();
		if(page != null) {
			new WorkbenchEditorsDialog(window).open();
		}		
	}
}
