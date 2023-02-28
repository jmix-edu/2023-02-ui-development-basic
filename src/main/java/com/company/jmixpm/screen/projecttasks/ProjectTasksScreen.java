package com.company.jmixpm.screen.projecttasks;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ProjectTasksScreen")
@UiDescriptor("project-tasks-screen.xml")
public class ProjectTasksScreen extends Screen {
    private static final Logger log = LoggerFactory.getLogger(ProjectTasksScreen.class);

    private Project selectedProject;

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public Project getSelectedProject() {
        return selectedProject;
    }

    public ProjectTasksScreen withSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
        log.info("Project: " + selectedProject);

        tasksDl.setParameter("projectId", selectedProject.getId());
        tasksDl.load();

        return this;
    }
}