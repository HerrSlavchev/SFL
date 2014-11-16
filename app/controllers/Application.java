package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;

public class Application extends Controller {

	public static Result index() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json data");
		} else {
			String name = json.findPath("name").textValue();
			if (name == null) {
				return badRequest("Missing parameter [name]");
			} else {
				return ok("Hello " + name);
			}
		}
	}

}
