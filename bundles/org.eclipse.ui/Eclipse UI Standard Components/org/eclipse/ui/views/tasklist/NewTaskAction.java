package org.eclipse.ui.views.tasklist;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.*;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.help.WorkbenchHelp;

/**
 * This action creates a new task. If a resource is currently
 * present at the tasklist's input, this task will be
 * associated with it. If the tasklist is currently
 * observing all the markers in the workbench, the task
 * will not be associated with any resource.
 * <p>The newly created task will have low priority,
 * fixed description text and will not be subject to
 * sorting or filtering until its desciprion is being
 * changed for the first time. For this reason, new
 * tasks remain at the top of the task list
 * until modified. It is possible that the newly
 * created task dissapears after that if its
 * type or some other property causes it to
 * be filtered out.
 */
/* package */ class NewTaskAction extends TaskAction {
	
/**
 * Creates the action.
 */
public NewTaskAction(TaskList tasklist, String id) {
	super(tasklist, id);
	WorkbenchHelp.setHelp(this, ITaskListHelpContextIds.NEW_TASK_ACTION);
}
/**
 * Opens the new task dialog and shows the newly created task when done.
 * The new task is created on the currently selected resource.
 */
public void run() {
	TaskPropertiesDialog dialog = new TaskPropertiesDialog(getShell());
	dialog.setResource(getTaskList().getResource());
	int result = dialog.open();
	if (result == dialog.OK) {
		showMarker(dialog.getMarker());
	}
}

/**
 * Show the newly created marker.
 */
private void showMarker(final IMarker marker) {
	if (marker == null) {
		return;
	}
	if (getTaskList().shouldShow(marker)) {
		// Need to do this in an asyncExec, even though we're in the UI thread here,
		// since the task list updates itself with the addition in an asyncExec,
		// which hasn't been processed yet.
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				getTaskList().setSelection(new StructuredSelection(marker), true);
			}
		});
	}
	else {
		MessageDialog.openInformation(
			getShell(),
			TaskListMessages.getString("NewTask.notShownTitle"), //$NON-NLS-1$
			TaskListMessages.getString("NewTask.notShownMsg")); //$NON-NLS-1$
	}
}
}
