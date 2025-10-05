package steps;

import pages.ModalCreateProjectPage;
import pages.ProjectsPage;
import pages.RepositoryPage;

public class ProjectStep {

    LoginStep loginStep = new LoginStep();
    ProjectsPage projectsPage = new ProjectsPage();
    ModalCreateProjectPage modalCreateProjectPage = new ModalCreateProjectPage();
    RepositoryPage repositoryPage = new RepositoryPage();

    public void createNewProject(String projectName,
                                 String projectCode,
                                 String description,
                                 String projectType) {
        modalCreateProjectPage.openModalCreate()
                .fillProjectDetails(projectName, projectCode, description, projectType)
                .clickCreate();
    }

    public void openProject(String user, String password, String nameProject) {
        loginStep.auth(user, password);
        projectsPage.openProject(nameProject);
        repositoryPage.isOpenedPage();
    }
}
