package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import BaoCaoDoAn.Entity.Project;
import BaoCaoDoAn.Entity.Report;

@Service
public interface IProjectService {
	@Autowired
	public List<Project> getProject(int id) ;
	
	@Autowired
	public List<Project> getAllProject() ;
	
	@Autowired
	public Project getProjectById(int id) ;
	
	@Autowired
	public int addProject(Project project);
	
	@Autowired
	public int deleteProject(int id);
	
	@Autowired
	public int editProject(int id) ;
	
	@Autowired
	public Project getProjectByGroupId(int groupId);

}
