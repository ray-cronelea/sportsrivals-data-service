package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;


@RepositoryRestResource(collectionResourceRel = "fixtures", path = "fixtures", excerptProjection = fixturesProjection.class)
public interface FixturesRepository extends MongoRepository<Fixtures, String> {

	Fixtures findTopBySportsRadarId(@Param("name") String name);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(Fixtures entity) { }

}

@Projection(name = "fixturesProjection", types = { Fixtures.class })
interface fixturesProjection {
	String getId();
	Integer getHomeTeamScore();
	Integer getAwayTeamScore();
	String getKickOffTime();
	String getSportsRadarId();
	Teams getHomeTeam();
	Teams getAwayTeam();
	Sports getSport();
}

