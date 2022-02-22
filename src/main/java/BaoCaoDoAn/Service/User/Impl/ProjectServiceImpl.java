package BaoCaoDoAn.Service.User.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Service.User.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectDAO projectDao;

	public List<Project> getProject(int id) {

		return projectDao.getProjectByGroup_id(id);
	}

	public List<Project> getAllProject() {

		return projectDao.getAllProject();
	}

	public int addProject(Project project) {

		return projectDao.addProject(project);
	}

	public int deleteProject(int id) {

		return projectDao.deleteProject(id);
	}

	public List<Project> getProjectById(int id) {

		return projectDao.getProjectByid(id);
	}

	public int editProject(int id) {

		return projectDao.editProject(id);
	}

	public List<Project> getProjectByTeacherId(int teacherId) {
		return projectDao.getProjectByTeacherId(teacherId);
	}
	

}
