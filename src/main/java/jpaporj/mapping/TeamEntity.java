package jpaporj.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
@Table(name = "TEAM")
public class TeamEntity {

	@Id
	@Column(name = "TEAM_ID")
	private String id;
	
	private String name;

	@OneToMany(mappedBy = "team")
	private List<MemberEntity> members;
	
	public TeamEntity() {
		super();
		members = new ArrayList<>();
	}

	public TeamEntity(String id, String name, List<MemberEntity> members) {
		super();
		this.id = id;
		this.name = name;
		this.members = members;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(List<MemberEntity> members) {
		this.members = members;
	}

	
	
}
