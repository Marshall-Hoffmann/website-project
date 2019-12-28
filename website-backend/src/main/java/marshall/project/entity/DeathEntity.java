package marshall.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Death_List")
public class DeathEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer deathId;
	
//	@Column
	private String charName;
	
//	@Column
	private String charAscendency;
	
//	@Column
	private Integer charLevel;
	
//	@Column 
	private Integer timePlayed;
	
//	@Column
	private String deathLocation;
	
//	@Column
	private String deathDescription;

	public Integer getDeathId() {
		return deathId;
	}

	public void setDeathId(Integer deathId) {
		this.deathId = deathId;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getCharAscendency() {
		return charAscendency;
	}

	public void setCharAscendency(String charAscendency) {
		this.charAscendency = charAscendency;
	}

	public Integer getCharLevel() {
		return charLevel;
	}

	public void setCharLevel(Integer charLevel) {
		this.charLevel = charLevel;
	}

	public Integer getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(Integer timePlayed) {
		this.timePlayed = timePlayed;
	}

	public String getDeathLocation() {
		return deathLocation;
	}

	public void setDeathLocation(String deathLocation) {
		this.deathLocation = deathLocation;
	}

	public String getDeathDescription() {
		return deathDescription;
	}

	public void setDeathDescription(String deathDescription) {
		this.deathDescription = deathDescription;
	}
	
	
	
}
