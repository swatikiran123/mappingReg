package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._


import models.User

class Application extends Controller {

var userForm: Form[User] = Form {
    mapping(
      "email" -> nonEmptyText,
      "password" ->nonEmptyText,
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "phonenumber" -> nonEmptyText
    )(User.apply)(User.unapply)
  }






	def index = Action {
		Ok(views.html.index("Your new application is ready."))
	}

	def userlogin = Action { implicit request =>
		Ok(views.html.register.userlogin("userlogin"))
	}

	def reg = Action { implicit request =>
		Ok(views.html.register.reg(userForm))
	}

	def welcome = Action { implicit request =>
		def values =  userForm.bind(userForm.bindFromRequest.data).get
		val int = User.add(values)
		//val int = User.delete
		val users = User.findAll
		Ok(views.html.register.welcome(users))
	}
	
}
