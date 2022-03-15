package BaoCaoDoAn.Entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class Group {
	
	private int id;
	@NotEmpty(message = "Name is empty")
	private String name;
	private List<Account> account;
	
	
	

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Group() {
		super();
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
	
}
