package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.Fixtures;
import com.appspot.sportsrivals.model.Teams;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "fixtures", path = "fixtures")
public interface FixturesRepository extends MongoRepository<Fixtures, String> {

	Fixtures findTopBySportsRadarId(@Param("name") String name);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(Fixtures entity) { }

}