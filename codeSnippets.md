
# Convert json string to object and back example

`RankingMessage rm = new ObjectMapper().readValue(message, RankingMessage.class);
System.out.println("Team object: " + team.toString());
Print object as json formatted for debugging
ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
System.out.println(ow.writeValueAsString(team));`
  