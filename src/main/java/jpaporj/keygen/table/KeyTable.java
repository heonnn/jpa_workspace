package jpaporj.keygen.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
@TableGenerator(
		name = "KEY_TABLE_GENERATOR", 
		table = "KEY_TABLE",
		pkColumnValue = "NEXT_VAL", allocationSize = 1)
@Table(name = "MEMBER")
public class KeyTable {

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "KEY_TABLE_GENERATOR")
	private int id;
	private String name;
	
	public KeyTable() {
		super();
	}

	public KeyTable(int id, String name) {
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
