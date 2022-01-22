package BaoCaoDoAn.Entity;

import java.sql.Date;

public class Project {
	private int id ;
	private String name ;
	private String urlProject ; 
	private Date createTime ;
	private int group_id ;
	
	
	public Project() {
		super();
	}
	public Project(int id, String name, String urlProject, Date createTime, int group_id) {
		super();
		this.id = id;
		this.name = name;
		this.urlProject = urlProject;
		this.createTime = createTime;
		this.group_id = group_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlProject() {
		return urlProject;
	}
	public void setUrlProject(String urlProject) {
		this.urlProject = urlProject;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
	
}