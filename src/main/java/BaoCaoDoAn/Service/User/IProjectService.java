package BaoCaoDoAn.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import BaoCaoDoAn.Entity.Project;

@Service
public interface IProjectService {
	@Autowired
	public List<Project> getProject(int id) ;
}
