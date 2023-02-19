package jpaporj.keygen.sequence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR", 
		sequenceName = "BOARD_SEQ",
		initialValue = 1, allocationSize = 1)
@Table(name = "MEMBER")
public class Sequence {

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "BOARD_SEQ_GENERATOR")
	private int id;
	private String name;
	
	public Sequence() {
		super();
	}

	public Sequence(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
