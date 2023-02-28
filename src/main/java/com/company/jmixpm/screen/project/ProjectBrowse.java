package com.company.jmixpm.screen.project;

import com.company.jmixpm.screen.projecttasks.ProjectTasksScreen;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
public class ProjectBrowse extends StandardLookup<Project> {
    private static final Logger log = LoggerFactory.getLogger(ProjectBrowse.class);

    @Autowired
    private ScreenBuilders screenBuilders;

    @Autowired
    private GroupTable<Project> projectsTable;

    @Subscribe("projectsTable.openTasks")
    public void onProjectsTableOpenTasks(Action.ActionPerformedEvent event) {
        log.info("Action performed");

        screenBuilders.screen(this)
                .withScreenClass(ProjectTasksScreen.class)
                .withOpenMode(OpenMode.DIALOG)
                .build()
                .withSelectedProject(projectsTable.getSingleSelected())
                .show();
    }
}