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
import org.eclipse.ui.AboutInfo;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.internal.dialogs.AboutDialog;

/**
 * Creates an About dialog and opens it.
 */
public class AboutAction extends Action {
	private IWorkbenchWindow workbenchWindow;
	
/**
 * Creates a new <code>AboutAction</code> with the given label
 */
public AboutAction(IWorkbenchWindow window, AboutInfo aboutInfo) {
	this.workbenchWindow = window;
	String productName = aboutInfo.getProductName();
	if (productName == null) {
		productName = ""; //$NON-NLS-1$
	}
	setText(WorkbenchMessages.format("AboutAction.text", new Object[] { productName })); //$NON-NLS-1$
	setToolTipText(WorkbenchMessages.format("AboutAction.toolTip", new Object[] { productName})); //$NON-NLS-1$
	setId(IWorkbenchActionConstants.ABOUT);
	setActionDefinitionId("org.eclipse.ui.help.aboutAction"); //$NON-NLS-1$
	WorkbenchHelp.setHelp(this, IHelpContextIds.ABOUT_ACTION);
}

/**
 * Perform the action: show about dialog.
 */
public void run() {
	new AboutDialog(workbenchWindow).open();
}
}
