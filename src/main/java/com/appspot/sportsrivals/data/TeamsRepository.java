package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.Teams;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "teams", path = "teams")
public interface TeamsRepository extends MongoRepository<Teams, String> {

	List<Teams> findByName(@Param("name") String name);
	Teams findFirstBySportRadarId(@Param("sportRadarId") String sportRadarId);
	List<Teams> findByCity(@Param("id") String id);
	List<Teams> findByState(@Param("id") String id);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(Teams entity) { }

}