package controllers

import play.api._
import play.api.mvc._


import play.api.data.Forms._
import play.api.data.validation.Constraints._

import play.api.mvc.{Action, Controller} 
import models.User
import 



var userForm: Form[validation] = Form {
    mapping(af
      "email" -> nonEmptyText,
      "password" ->nonEmptyText,
      "confirmpassword" -> nonEmptyText,
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "phonenumber" -> nonEmptyText
    )(validation.apply)(validation.unapply)
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
		val int = User.add
		//val int = User.delete
		val users = User.findAll
		Ok(views.html.register.welcome(users))
	}


	
}
