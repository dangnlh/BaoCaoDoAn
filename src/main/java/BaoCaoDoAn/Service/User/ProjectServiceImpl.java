package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BaoCaoDoAn.Dao.ProjectDAO;
import BaoCaoDoAn.Entity.Project;

@Service
public class ProjectServiceImpl implements IProjectService{
	
@Autowired
	private ProjectDAO projectDao ;

	public List<Project> getProject(int id) {
		
		return projectDao.getProject(id) ;
	}

}
