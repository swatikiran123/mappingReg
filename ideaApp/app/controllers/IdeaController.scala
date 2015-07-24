package controllers

import play.api.mvc.{Action, Controller}
import models.Idea

class IdeaController extends Controller {

	def list = Action { implicit request =>
		val ideas = Idea.findAll
		Ok(views.html.idea.list(ideas))
	}
}