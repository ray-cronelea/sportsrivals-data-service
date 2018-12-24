package com.appspot.sportsrivals.controllers;

import com.appspot.sportsrivals.data.*;
import com.appspot.sportsrivals.model.Cities;
import com.appspot.sportsrivals.model.Sports;
import com.appspot.sportsrivals.model.States;
import com.appspot.sportsrivals.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/seed")
public class SeedController {


	private SportsRepository sportsRepository;
	private CitiesRepository citiesRepository;
	private StatesRepository statesRepository;
	private TeamsRepository teamsRepository;
	private FixturesRepository fixturesRepository;

	@Autowired public void setSportsRepository(SportsRepository sportsRepository) { this.sportsRepository = sportsRepository; }
	@Autowired public void setCitiesRepository(CitiesRepository citiesRepository) { this.citiesRepository = citiesRepository; }
	@Autowired public void setStatesRepository(StatesRepository statesRepository) { this.statesRepository = statesRepository; }
	@Autowired public void setTeamsRepositoryInterface(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }
	@Autowired public void setFixturesRepositoryInterface(FixturesRepository fixturesRepository) { this.fixturesRepository = fixturesRepository; }

	@GetMapping({"", "/", "/all"})
	public String seedAll(Model model) {

		sportsRepository.deleteAll();
		citiesRepository.deleteAll();
		statesRepository.deleteAll();
		teamsRepository.deleteAll();

		seedSports();
		seedCities();
		seedStates();
		seedTeams();
		model.addAttribute("message", "Success!");
		return "message";
	}

	@GetMapping({"/test"})
	public String Test(Model model) {

		//int val = teamsRepository.findTeamsForStateCustom("NY");
		//model.addAttribute("message", String.valueOf(val));

		return "message";
	}

	@GetMapping("/sports")
	public String seedSportsMap(Model model) {
		sportsRepository.deleteAll();
		seedSports();
		model.addAttribute("message", "Success!");
		return "message";
	}

	@GetMapping("/cities")
	public String seedCitiesMap(Model model) {
		citiesRepository.deleteAll();
		seedCities();
		model.addAttribute("message", "Success!");
		return "message";
	}

	@GetMapping("/states")
	public String seedStatesMap(Model model) {
		statesRepository.deleteAll();
		seedStates();
		model.addAttribute("message", "Success!");
		return "message";
	}

	@GetMapping("/teams")
	public String seedTeamsMap(Model model) {
		teamsRepository.deleteAll();
		seedTeams();
		model.addAttribute("message", "Success!");
		return "message";
	}

	void seedSports(){
		List<Sports> ls = new ArrayList<>();
		ls.add(new Sports("NBA","Basketball","https://sportrankerstorage.blob.core.windows.net/sports-images/nba.svg"));
		ls.add(new Sports("NFL","American Football","https://sportrankerstorage.blob.core.windows.net/sports-images/nfl.svg"));
		ls.add(new Sports("NHL","Ice Hockey","https://sportrankerstorage.blob.core.windows.net/sports-images/nhl.svg"));
		ls.add(new Sports("MLB", "Baseball","https://sportrankerstorage.blob.core.windows.net/sports-images/mlb.svg"));

		for(Sports s : ls){
			sportsRepository.save(s);
		}
	}

	void seedCities(){
		List<Cities> lc = new ArrayList<>();
		lc.add(new Cities("Anaheim", 1500.0, ""));
		lc.add(new Cities("Atlanta", 1500.0, ""));
		lc.add(new Cities("Baltimore", 1500.0, ""));
		lc.add(new Cities("Boston", 1500.0, ""));
		lc.add(new Cities("Bronx", 1500.0, ""));
		lc.add(new Cities("Brooklyn", 1500.0, ""));
		lc.add(new Cities("Buffalo", 1500.0, ""));
		lc.add(new Cities("Calgary", 1500.0, ""));
		lc.add(new Cities("Charlotte", 1500.0, ""));
		lc.add(new Cities("Chicago", 1500.0, ""));
		lc.add(new Cities("Cincinnati", 1500.0, ""));
		lc.add(new Cities("Cleveland", 1500.0, ""));
		lc.add(new Cities("Columbus", 1500.0, ""));
		lc.add(new Cities("Dallas", 1500.0, ""));
		lc.add(new Cities("Denver", 1500.0, ""));
		lc.add(new Cities("Detroit", 1500.0, ""));
		lc.add(new Cities("Edmonton", 1500.0, ""));
		lc.add(new Cities("Green Bay", 1500.0, ""));
		lc.add(new Cities("Houston", 1500.0, ""));
		lc.add(new Cities("Indianapolis", 1500.0, ""));
		lc.add(new Cities("Jacksonville", 1500.0, ""));
		lc.add(new Cities("Kansas City", 1500.0, ""));
		lc.add(new Cities("Las Vegas", 1500.0, ""));
		lc.add(new Cities("Los Angeles", 1500.0, ""));
		lc.add(new Cities("Memphis", 1500.0, ""));
		lc.add(new Cities("Miami", 1500.0, ""));
		lc.add(new Cities("Milwaukee", 1500.0, ""));
		lc.add(new Cities("Mimai", 1500.0, ""));
		lc.add(new Cities("Minneapolis", 1500.0, ""));
		lc.add(new Cities("Montreal", 1500.0, ""));
		lc.add(new Cities("Nashville", 1500.0, ""));
		lc.add(new Cities("New Orleans", 1500.0, ""));
		lc.add(new Cities("New York", 1500.0, ""));
		lc.add(new Cities("Newark", 1500.0, ""));
		lc.add(new Cities("Oakland", 1500.0, ""));
		lc.add(new Cities("Oklahoma City", 1500.0, ""));
		lc.add(new Cities("Orlando", 1500.0, ""));
		lc.add(new Cities("Ottawa", 1500.0, ""));
		lc.add(new Cities("Philadelphia", 1500.0, ""));
		lc.add(new Cities("Phoenix", 1500.0, ""));
		lc.add(new Cities("Pittsburgh", 1500.0, ""));
		lc.add(new Cities("Portland", 1500.0, ""));
		lc.add(new Cities("Raleigh", 1500.0, ""));
		lc.add(new Cities("Sacramento", 1500.0, ""));
		lc.add(new Cities("Salt Lake City", 1500.0, ""));
		lc.add(new Cities("San Antonio", 1500.0, ""));
		lc.add(new Cities("San Diego", 1500.0, ""));
		lc.add(new Cities("San Francisco", 1500.0, ""));
		lc.add(new Cities("San Jose", 1500.0, ""));
		lc.add(new Cities("Seattle", 1500.0, ""));
		lc.add(new Cities("St. Louis", 1500.0, ""));
		lc.add(new Cities("St. Paul", 1500.0, ""));
		lc.add(new Cities("Sunrise", 1500.0, ""));
		lc.add(new Cities("Tampa", 1500.0, ""));
		lc.add(new Cities("Toronto", 1500.0, ""));
		lc.add(new Cities("Vancouver", 1500.0, ""));
		lc.add(new Cities("Washington", 1500.0, ""));
		lc.add(new Cities("Winnipeg", 1500.0, ""));

		for(Cities c : lc){
			citiesRepository.save(c);
		}
	}

	void seedStates(){
		List<States> ls = new ArrayList<>();
		ls.add(new States("AL","Alabama","Montgomery",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/alabama.svg"));
		ls.add(new States("AK","Alaska","Juneau",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/alaska.svg"));
		ls.add(new States("AZ","Arizona","Phoenix",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/arizona.svg"));
		ls.add(new States("AR","Arkansas","Little Rock",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/arkansas.svg"));
		ls.add(new States("CA","California","Sacramento",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/california.svg"));
		ls.add(new States("CO","Colorado","Denver",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/colorado.svg"));
		ls.add(new States("CT","Connecticut","Hartford",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/connecticut.svg"));
		ls.add(new States("DE","Delaware","Dover",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/delaware.svg"));
		ls.add(new States("FL","Florida","Tallahassee",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/florida.svg"));
		ls.add(new States("GA","Georgia","Atlanta",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/georgia.svg"));
		ls.add(new States("HI","Hawaii","Honolulu",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/hawaii.svg"));
		ls.add(new States("ID","Idaho","Boise",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/idaho.svg"));
		ls.add(new States("IL","Illinois","Springfield",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/illinois.svg"));
		ls.add(new States("IN","Indiana","Indianapolis",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/indiana.svg"));
		ls.add(new States("IA","Iowa","Des Moines",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/iowa.svg"));
		ls.add(new States("KS","Kansas","Topeka",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/kansas.svg"));
		ls.add(new States("KY","Kentucky","Frankfort",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/kentucky.svg"));
		ls.add(new States("LA","Louisiana","Baton Rouge",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/louisiana.svg"));
		ls.add(new States("ME","Maine","Augusta",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/maine.svg"));
		ls.add(new States("MD","Maryland","Annapolis",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/maryland.svg"));
		ls.add(new States("MA","Massachusetts","Boston",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/massachusetts.svg"));
		ls.add(new States("MI","Michigan","Lansing",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/michigan.svg"));
		ls.add(new States("MN","Minnesota","Saint Paul",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/minnesota.svg"));
		ls.add(new States("MS","Mississippi","Jackson",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/mississippi.svg"));
		ls.add(new States("MO","Missouri","Jefferson City",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/missouri.svg"));
		ls.add(new States("MT","Montana","Helena",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/montana.svg"));
		ls.add(new States("NE","Nebraska","Lincoln",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/nebraska.svg"));
		ls.add(new States("NV","Nevada","Carson City",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/nevada.svg"));
		ls.add(new States("NH","New Hampshire","Concord",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/newhampshire.svg"));
		ls.add(new States("NJ","New Jersey","Trenton",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/newjersey.svg"));
		ls.add(new States("NM","New Mexico","Santa Fe",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/newmexico.svg"));
		ls.add(new States("NY","New York","Albany",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/newyork.svg"));
		ls.add(new States("NC","North Carolina","Raleigh",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/northcarolina.svg"));
		ls.add(new States("ND","North Dakota","Bismarck",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/northdakota.svg"));
		ls.add(new States("OH","Ohio","Columbus",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/ohio.svg"));
		ls.add(new States("OK","Oklahoma","Oklahoma City",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/oklahoma.svg"));
		ls.add(new States("OR","Oregon","Salem",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/oregon.svg"));
		ls.add(new States("PA","Pennsylvania","Harrisburg",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/pennsylvania.svg"));
		ls.add(new States("RI","Rhode Island","Providence",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/rhodeisland.svg"));
		ls.add(new States("SC","South Carolina","Columbia",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/southcarolina.svg"));
		ls.add(new States("SD","South Dakota","Pierre",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/southdakota.svg"));
		ls.add(new States("TN","Tennessee","Nashville",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/tennessee.svg"));
		ls.add(new States("TX","Texas","Austin",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/texas.svg"));
		ls.add(new States("UT","Utah","Salt Lake City",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/utah.svg"));
		ls.add(new States("VT","Vermont","Montpelier",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/vermont.svg"));
		ls.add(new States("VA","Virginia","Richmond",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/virginia.svg"));
		ls.add(new States("WA","Washington","Olympia",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/washington.svg"));
		ls.add(new States("WV","West Virginia","Charleston",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/westvirginia.svg"));
		ls.add(new States("WI","Wisconsin","Madison",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/wisconsin.svg"));
		ls.add(new States("WY","Wyoming","Cheyenne",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/wyoming.svg"));
		ls.add(new States("DC","Washington DC","Washington DC",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/washingtondc.svg"));
		ls.add(new States("ON","Ontario","Toronto",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/ontario.svg"));
		ls.add(new States("QC","Quebec","Quebec City",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/quebec.svg"));
		ls.add(new States("MB","Manitoba","Winnipeg",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/manitoba.svg"));
		ls.add(new States("AB","Alberta","Edmonton",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/alberta.svg"));
		ls.add(new States("BC","British Columbia","Victoria",1500.0,"https://sportrankerstorage.blob.core.windows.net/locations-images/britishcolumbia.svg"));



		for(States s : ls){
			statesRepository.save(s);
		}
	}

	void seedTeams(){

		List<List<String>> ls = new ArrayList<>();


		ls.add(Arrays.asList("Buffalo Bills", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/bills.svg", "768c92aa-75ff-4a43-bcc0-f2798c2e1724", "NFL", "Buffalo", "NY"));
		ls.add(Arrays.asList("Miami Dolphins", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/dolphins.svg", "4809ecb0-abd3-451d-9c4a-92a90b83ca06", "NFL", "Miami", "FL"));
		ls.add(Arrays.asList("New York Jets", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/jets.svg", "5fee86ae-74ab-4bdd-8416-42a9dd9964f3", "NFL", "New York", "NY"));
		ls.add(Arrays.asList("New England Patriots", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/patriots.svg", "97354895-8c77-4fd4-a860-32e62ea7382a", "NFL", "Boston", "MA"));
		ls.add(Arrays.asList("Cincinnati Bengals", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/bengals.svg", "ad4ae08f-d808-42d5-a1e6-e9bc4e34d123", "NFL", "Cincinnati", "OH"));
		ls.add(Arrays.asList("Cleveland Browns", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/browns.svg", "d5a2eb42-8065-4174-ab79-0a6fa820e35e", "NFL", "Cleveland", "OH"));
		ls.add(Arrays.asList("Baltimore Ravens", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/ravens.svg", "ebd87119-b331-4469-9ea6-d51fe3ce2f1c", "NFL", "Baltimore", "MD"));
		ls.add(Arrays.asList("Pittsburgh Steelers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/steelers.svg", "cb2f9f1f-ac67-424e-9e72-1475cb0ed398", "NFL", "Pittsburgh", "PA"));
		ls.add(Arrays.asList("Indianapolis Colts", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/colts.svg", "82cf9565-6eb9-4f01-bdbd-5aa0d472fcd9", "NFL", "Indianapolis", "IN"));
		ls.add(Arrays.asList("Jacksonville Jaguars", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/jaguars.svg", "f7ddd7fa-0bae-4f90-bc8e-669e4d6cf2de", "NFL", "Jacksonville", "FL"));
		ls.add(Arrays.asList("Houston Texans", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/texans.svg", "82d2d380-3834-4938-835f-aec541e5ece7", "NFL", "Houston", "TX"));
		ls.add(Arrays.asList("Tennessee Titans", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/titans.svg", "d26a1ca5-722d-4274-8f97-c92e49c96315", "NFL", "Nashville", "TN"));
		ls.add(Arrays.asList("Denver Broncos", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/broncos.svg", "324decdd-aa1b-4074-8958-c009d8fac31a", "NFL", "Denver", "CO"));
		ls.add(Arrays.asList("Los Angeles Chargers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/chargers.svg", "1f6dcffb-9823-43cd-9ff4-e7a8466749b5", "NFL", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Kansas City Chiefs", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/chiefs.svg", "6680d28d-d4d2-49f6-aace-5292d3ec02c2", "NFL", "Kansas City", "MO"));
		ls.add(Arrays.asList("Oakland Raiders", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/raiders.svg", "1c1cec48-6352-4556-b789-35304c1a6ae1", "NFL", "Oakland", "CA"));
		ls.add(Arrays.asList("Dallas Cowboys", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/cowboys.svg", "e627eec7-bbae-4fa4-8e73-8e1d6bc5c060", "NFL", "Dallas", "TX"));
		ls.add(Arrays.asList("Philadelphia Eagles", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/eagles.svg", "386bdbf9-9eea-4869-bb9a-274b0bc66e80", "NFL", "Philadelphia", "PA"));
		ls.add(Arrays.asList("New York Giants", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/giants.svg", "5d4c85c7-d84e-4e10-bd6a-8a15ebecca5c", "NFL", "New York", "NJ"));
		ls.add(Arrays.asList("Washington Redskins", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/redskins.svg", "22052ff7-c065-42ee-bc8f-c4691c50e624", "NFL", "Washington", "DC"));
		ls.add(Arrays.asList("Chicago Bears", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/bears.svg", "6dc1933f-ca90-46e6-aaf7-9b95cc44306a", "NFL", "Chicago", "IL"));
		ls.add(Arrays.asList("Detroit Lions", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/lions.svg", "6e3bcf22-277d-4c06-b019-62aded51654f", "NFL", "Detroit", "MI"));
		ls.add(Arrays.asList("Green Bay Packers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/packers.svg", "a20471b4-a8d9-40c7-95ad-90cc30e46932", "NFL", "Green Bay", "WI"));
		ls.add(Arrays.asList("Minnesota Vikings", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/vikings.svg", "33405046-04ee-4058-a950-d606f8c30852", "NFL", "Minneapolis", "MN"));
		ls.add(Arrays.asList("Tampa Bay Buccaneers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/buccaneers.svg", "4254d319-1bc7-4f81-b4ab-b5e6f3402b69", "NFL", "Tampa", "FL"));
		ls.add(Arrays.asList("Atlanta Falcons", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/falcons.svg", "e6aa13a4-0055-48a9-bc41-be28dc106929", "NFL", "Atlanta", "GA"));
		ls.add(Arrays.asList("Carolina Panthers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/panthers.svg", "f14bf5cc-9a82-4a38-bc15-d39f75ed5314", "NFL", "Charlotte", "NC"));
		ls.add(Arrays.asList("New Orleans Saints", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/saints.svg", "0d855753-ea21-4953-89f9-0e20aff9eb73", "NFL", "New Orleans", "LA"));
		ls.add(Arrays.asList("San Francisco 49ers", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/49ers.svg", "f0e724b0-4cbf-495a-be47-013907608da9", "NFL", "San Francisco", "CA"));
		ls.add(Arrays.asList("Arizona Cardinals", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/cardinals.svg", "f8e4d2ab-53f9-4e9f-8c4a-9bc278094a84", "NFL", "Phoenix", "AZ"));
		ls.add(Arrays.asList("Los Angeles Rams", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/rams.svg", "2eff2a03-54d4-46ba-890e-2bc3925548f3", "NFL", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Seattle Seahawks", "1500", "https://sportrankerstorage.blob.core.windows.net/nfl-team-logos/seahawks.svg", "3d08af9e-c767-4f88-a7dc-b920c6d2b4a8", "NFL", "Seattle", "WA"));
		ls.add(Arrays.asList("Washington Wizards", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/wizards.svg", "583ec8d4-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Washington", "DC"));
		ls.add(Arrays.asList("Charlotte Hornets", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/hornets.svg", "583ec97e-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Charlotte", "NC"));
		ls.add(Arrays.asList("Atlanta Hawks", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/hawks.svg", "583ecb8f-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Atlanta", "GA"));
		ls.add(Arrays.asList("Miami Heat", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/heat.svg", "583ecea6-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Miami", "FL"));
		ls.add(Arrays.asList("Orlando Magic", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/magic.svg", "583ed157-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Orlando", "FL"));
		ls.add(Arrays.asList("New York Knicks", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/knicks.svg", "583ec70e-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "New York", "NY"));
		ls.add(Arrays.asList("Philadelphia 76ers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/76ers.svg", "583ec87d-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Philadelphia", "PA"));
		ls.add(Arrays.asList("Brooklyn Nets", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/nets.svg", "583ec9d6-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Brooklyn", "NY"));
		ls.add(Arrays.asList("Boston Celtics", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/celtics.svg", "583eccfa-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Boston", "MA"));
		ls.add(Arrays.asList("Toronto Raptors", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/raptors.svg", "583ecda6-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Toronto", "ON"));
		ls.add(Arrays.asList("Chicago Bulls", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/bulls.svg", "583ec5fd-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Chicago", "IL"));
		ls.add(Arrays.asList("Cleveland Cavaliers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/cavaliers.svg", "583ec773-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Cleveland", "OH"));
		ls.add(Arrays.asList("Indiana Pacers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/pacers.svg", "583ec7cd-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Indianapolis", "IN"));
		ls.add(Arrays.asList("Detroit Pistons", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/pistons.svg", "583ec928-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Detroit", "MI"));
		ls.add(Arrays.asList("Milwaukee Bucks", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/bucks.svg", "583ecefd-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Milwaukee", "WI"));
		ls.add(Arrays.asList("Minnesota Timberwolves", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/timberwolves.svg", "583eca2f-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Minneapolis", "MN"));
		ls.add(Arrays.asList("Utah Jazz", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/jazz.svg", "583ece50-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Salt Lake City", "UT"));
		ls.add(Arrays.asList("Oklahoma City Thunder", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/thunder.svg", "583ecfff-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Oklahoma City", "OK"));
		ls.add(Arrays.asList("Portland Trail Blazers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/trailblazers.svg", "583ed056-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Portland", "OR"));
		ls.add(Arrays.asList("Denver Nuggets", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/nuggets.svg", "583ed102-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Denver", "CO"));
		ls.add(Arrays.asList("Memphis Grizzlies", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/grizziles.svg", "583eca88-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Memphis", "TN"));
		ls.add(Arrays.asList("Houston Rockets", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/rockets.svg", "583ecb3a-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Houston", "TX"));
		ls.add(Arrays.asList("New Orleans Pelicans", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/pelicans.svg", "583ecc9a-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "New Orleans", "LA"));
		ls.add(Arrays.asList("San Antonio Spurs", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/spurs.svg", "583ecd4f-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "San Antonio", "TX"));
		ls.add(Arrays.asList("Dallas Mavericks", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/mavericks.svg", "583ecf50-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Dallas", "TX"));
		ls.add(Arrays.asList("Golden State Warriors", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/warriors.svg", "583ec825-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Oakland", "CA"));
		ls.add(Arrays.asList("Los Angeles Lakers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/lakers.svg", "583ecae2-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Los Angeles Clippers", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/clippers.svg", "583ecdfb-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Phoenix Suns", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/suns.svg", "583ecfa8-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Phoenix", "AZ"));
		ls.add(Arrays.asList("Sacramento Kings", "1500", "https://sportrankerstorage.blob.core.windows.net/nba-team-logos/kings.svg", "583ed0ac-fb46-11e1-82cb-f4ce4684ea4c", "NBA", "Sacramento", "CA"));
		ls.add(Arrays.asList("Vegas Golden Knights", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/goldenknights.svg", "42376e1c-6da8-461e-9443-cfcf0a9fcc4d", "NHL", "Las Vegas", "NV"));
		ls.add(Arrays.asList("Los Angeles Kings", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/kings.svg", "44151f7a-0f24-11e2-8525-18a905767e44", "NHL", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Arizona Coyotes", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/coyotes.svg", "44153da1-0f24-11e2-8525-18a905767e44", "NHL", "Phoenix", "AZ"));
		ls.add(Arrays.asList("San Jose Sharks", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/sharks.svg", "44155909-0f24-11e2-8525-18a905767e44", "NHL", "San Jose", "CA"));
		ls.add(Arrays.asList("Calgary Flames", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/flamers.svg", "44159241-0f24-11e2-8525-18a905767e44", "NHL", "Calgary", "AB"));
		ls.add(Arrays.asList("Vancouver Canucks", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/canuks.svg", "4415b0a7-0f24-11e2-8525-18a905767e44", "NHL", "Vancouver", "BC"));
		ls.add(Arrays.asList("Edmonton Oilers", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/oilers.svg", "4415ea6c-0f24-11e2-8525-18a905767e44", "NHL", "Edmonton", "AB"));
		ls.add(Arrays.asList("Anaheim Ducks", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/ducks.svg", "441862de-0f24-11e2-8525-18a905767e44", "NHL", "Anaheim", "CA"));
		ls.add(Arrays.asList("Dallas Stars", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/stars.svg", "44157522-0f24-11e2-8525-18a905767e44", "NHL", "Dallas", "TX"));
		ls.add(Arrays.asList("Colorado Avalanche", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/avalanche.svg", "4415ce44-0f24-11e2-8525-18a905767e44", "NHL", "Denver", "CO"));
		ls.add(Arrays.asList("Minnesota Wild", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/wild.svg", "4416091c-0f24-11e2-8525-18a905767e44", "NHL", "St. Paul", "MN"));
		ls.add(Arrays.asList("Chicago Blackhawks", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/blackhawks.svg", "4416272f-0f24-11e2-8525-18a905767e44", "NHL", "Chicago", "IL"));
		ls.add(Arrays.asList("Nashville Predators", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/predators.svg", "441643b7-0f24-11e2-8525-18a905767e44", "NHL", "Nashville", "TN"));
		ls.add(Arrays.asList("St. Louis Blues", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/blues.svg", "441660ea-0f24-11e2-8525-18a905767e44", "NHL", "St. Louis", "MO"));
		ls.add(Arrays.asList("Winnipeg Jets", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/jets.svg", "44180e55-0f24-11e2-8525-18a905767e44", "NHL", "Winnipeg", "MB"));
		ls.add(Arrays.asList("Detroit Red Wings", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/redwings.svg", "44169bb9-0f24-11e2-8525-18a905767e44", "NHL", "Detroit", "MI"));
		ls.add(Arrays.asList("Boston Bruins", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/bruins.svg", "4416ba1a-0f24-11e2-8525-18a905767e44", "NHL", "Boston", "MA"));
		ls.add(Arrays.asList("Buffalo Sabres", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/sabres.svg", "4416d559-0f24-11e2-8525-18a905767e44", "NHL", "Buffalo", "NY"));
		ls.add(Arrays.asList("Ottawa Senators", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/senators.svg", "4416f5e2-0f24-11e2-8525-18a905767e44", "NHL", "Ottawa", "ON"));
		ls.add(Arrays.asList("Montreal Canadiens", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/canadiens.svg", "441713b7-0f24-11e2-8525-18a905767e44", "NHL", "Montreal", "QC"));
		ls.add(Arrays.asList("Toronto Maple Leafs", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/mapleleafs.svg", "441730a9-0f24-11e2-8525-18a905767e44", "NHL", "Toronto", "ON"));
		ls.add(Arrays.asList("Tampa Bay Lightning", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/lightning.svg", "4417d3cb-0f24-11e2-8525-18a905767e44", "NHL", "Tampa", "FL"));
		ls.add(Arrays.asList("Florida Panthers", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/panthers.svg", "4418464d-0f24-11e2-8525-18a905767e44", "NHL", "Sunrise", "FL"));
		ls.add(Arrays.asList("Columbus Blue Jackets", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/bluejackets.svg", "44167db4-0f24-11e2-8525-18a905767e44", "NHL", "Columbus", "OH"));
		ls.add(Arrays.asList("New Jersey Devils", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/devils.svg", "44174b0c-0f24-11e2-8525-18a905767e44", "NHL", "Newark", "NJ"));
		ls.add(Arrays.asList("New York Islanders", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/islanders.svg", "441766b9-0f24-11e2-8525-18a905767e44", "NHL", "New York", "NY"));
		ls.add(Arrays.asList("New York Rangers", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/rangers.svg", "441781b9-0f24-11e2-8525-18a905767e44", "NHL", "New York", "NY"));
		ls.add(Arrays.asList("Philadelphia Flyers", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/flyers.svg", "44179d47-0f24-11e2-8525-18a905767e44", "NHL", "Philadelphia", "PA"));
		ls.add(Arrays.asList("Pittsburgh Penguins", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/penguins.svg", "4417b7d7-0f24-11e2-8525-18a905767e44", "NHL", "Pittsburgh", "PA"));
		ls.add(Arrays.asList("Washington Capitals", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/capitals.svg", "4417eede-0f24-11e2-8525-18a905767e44", "NHL", "Washington", "DC"));
		ls.add(Arrays.asList("Carolina Hurricanes", "1500", "https://sportrankerstorage.blob.core.windows.net/nhl-team-logos/hurricanes.svg", "44182a9d-0f24-11e2-8525-18a905767e44", "NHL", "Raleigh", "NC"));
		ls.add(Arrays.asList("Toronto Blue Jays", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/bluejays.svg", "1d678440-b4b1-4954-9b39-70afb3ebbcfa", "MLB", "Toronto", "ON"));
		ls.add(Arrays.asList("Tampa Bay Rays", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/rays.svg", "bdc11650-6f74-49c4-875e-778aeb7632d9", "MLB", "Tampa", "FL"));
		ls.add(Arrays.asList("Baltimore Orioles", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/orioles.svg", "75729d34-bca7-4a0f-b3df-6f26c6ad3719", "MLB", "Baltimore", "MD"));
		ls.add(Arrays.asList("Boston Red Sox", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/redsox.svg", "93941372-eb4c-4c40-aced-fe3267174393", "MLB", "Boston", "MA"));
		ls.add(Arrays.asList("New York Yankees", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/yankees.svg", "a09ec676-f887-43dc-bbb3-cf4bbaee9a18", "MLB", "Bronx", "NY"));
		ls.add(Arrays.asList("Kansas City Royals", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/royals.svg", "833a51a9-0d84-410f-bd77-da08c3e5e26e", "MLB", "Kansas City", "MO"));
		ls.add(Arrays.asList("Cleveland Indians", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/indians.svg", "80715d0d-0d2a-450f-a970-1b9a3b18c7e7", "MLB", "Cleveland", "OH"));
		ls.add(Arrays.asList("Chicago White Sox", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/whitesox.svg", "47f490cd-2f58-4ef7-9dfd-2ad6ba6c1ae8", "MLB", "Chicago", "IL"));
		ls.add(Arrays.asList("Detroit Tigers", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/tigers.svg", "575c19b7-4052-41c2-9f0a-1c5813d02f99", "MLB", "Detroit", "MI"));
		ls.add(Arrays.asList("Minnesota Twins", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/twins.svg", "aa34e0ed-f342-4ec6-b774-c79b47b60e2d", "MLB", "Minneapolis", "MN"));
		ls.add(Arrays.asList("Seattle Mariners", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/mariners.svg", "43a39081-52b4-4f93-ad29-da7f329ea960", "MLB", "Seattle", "WA"));
		ls.add(Arrays.asList("Los Angeles Angels", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/angels.svg", "4f735188-37c8-473d-ae32-1f7e34ccf892", "MLB", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Oakland Athletics", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/athletics.svg", "27a59d3b-ff7c-48ea-b016-4798f560f5e1", "MLB", "Oakland", "CA"));
		ls.add(Arrays.asList("Texas Rangers", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/rangers.svg", "d99f919b-1534-4516-8e8a-9cd106c6d8cd", "MLB", "Dallas", "TX"));
		ls.add(Arrays.asList("Houston Astros", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/astros.svg", "eb21dadd-8f10-4095-8bf3-dfb3b779f107", "MLB", "Houston", "TX"));
		ls.add(Arrays.asList("Cincinnati Reds", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/reds.svg", "c874a065-c115-4e7d-b0f0-235584fb0e6f", "MLB", "Cincinnati", "OH"));
		ls.add(Arrays.asList("Pittsburgh Pirates", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/pirates.svg", "481dfe7e-5dab-46ab-a49f-9dcc2b6e2cfd", "MLB", "Pittsburgh", "PA"));
		ls.add(Arrays.asList("Chicago Cubs", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/cubs.svg", "55714da8-fcaf-4574-8443-59bfb511a524", "MLB", "Chicago", "IL"));
		ls.add(Arrays.asList("St. Louis Cardinals", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/cardinals.svg", "44671792-dc02-4fdd-a5ad-f5f17edaa9d7", "MLB", "St. Louis", "MO"));
		ls.add(Arrays.asList("Milwaukee Brewers", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/brewers.svg", "dcfd5266-00ce-442c-bc09-264cd20cf455", "MLB", "Milwaukee", "WI"));
		ls.add(Arrays.asList("Los Angeles Dodgers", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/dodgers.svg", "ef64da7f-cfaf-4300-87b0-9313386b977c", "MLB", "Los Angeles", "CA"));
		ls.add(Arrays.asList("Arizona Diamondbacks", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/diamondbacks.svg", "25507be1-6a68-4267-bd82-e097d94b359b", "MLB", "Phoenix", "AZ"));
		ls.add(Arrays.asList("San Francisco Giants", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/giants.svg", "a7723160-10b7-4277-a309-d8dd95a8ae65", "MLB", "San Francisco", "CA"));
		ls.add(Arrays.asList("Colorado Rockies", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/rockies.svg", "29dd9a87-5bcc-4774-80c3-7f50d985068b", "MLB", "Denver", "CO"));
		ls.add(Arrays.asList("San Diego Padres", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/padres.svg", "d52d5339-cbdd-43f3-9dfa-a42fd588b9a3", "MLB", "San Diego", "CA"));
		ls.add(Arrays.asList("Philadelphia Phillies", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/phillies.svg", "2142e1ba-3b40-445c-b8bb-f1f8b1054220", "MLB", "Philadelphia", "PA"));
		ls.add(Arrays.asList("New York Mets", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/mets.svg", "f246a5e5-afdb-479c-9aaa-c68beeda7af6", "MLB", "New York", "NY"));
		ls.add(Arrays.asList("Miami Marlins", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/marlins.svg", "03556285-bdbb-4576-a06d-42f71f46ddc5", "MLB", "Mimai", "FL"));
		ls.add(Arrays.asList("Atlanta Braves", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/braves.svg", "12079497-e414-450a-8bf2-29f91de646bf", "MLB", "Atlanta", "GA"));
		ls.add(Arrays.asList("Washington Nationals", "1500", "https://sportrankerstorage.blob.core.windows.net/mlb-team-logos/nationals.svg", "d89bed32-3aee-4407-99e3-4103641b999a", "MLB", "Washington", "DC"));

		for(List<String> l : ls){

			Sports sport = sportsRepository.findByName(l.get(4)).get(0);
			Cities city = citiesRepository.findByName(l.get(5)).get(0);
			States state = statesRepository.findByName(l.get(6)).get(0);
			Teams team = new Teams(l.get(0), Double.valueOf(l.get(1)), l.get(2), l.get(3), sport, city, state);

			teamsRepository.save(team);
		}
	}

}
