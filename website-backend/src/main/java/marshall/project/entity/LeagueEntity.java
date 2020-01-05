package marshall.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LEAGUE_LIST")
public class LeagueEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer leagueId;
	
	private String leagueName;
}
