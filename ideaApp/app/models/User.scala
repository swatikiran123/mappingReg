package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class User(
	email:String,
	password: String,
	firstName:String,
	lastName:String,
	phonenumber:String
)


object User {


	val parser: RowParser[User] = {
		get[String]("members.email") ~ 
		get[String]("members.password") ~ 
		get[String]("members.firstName") ~
		get[String]("members.lastName") ~
		get[String]("members.phonenumber") map {
	    	case email ~ password ~ firstName ~ lastName ~ phonenumber
	    		=> User(email,password,firstName,lastName,phonenumber)
	    	}
	}

	//def delete: Unit = {
		//DB.withConnection { implicit c =>
		//SQL("delete from users where firstName ='swati'").executeUpdate()
		//}
  
    def findAll: List[User] = {
        DB.withConnection { implicit connection =>
            SQL("SELECT * FROM members").as(parser *)
        }
    }


	def add(key: User) {
		DB.withConnection{  implicit c=> 
		SQL("""insert into members (email, password, firstName, lastName, phonenumber ) 
			values({email},{password},{firstName},{lastName},{phonenumber})""")
			.on ("email"-> key.email, "password"->key.password,
			"firstName"-> key.firstName,
			"lastName" -> key.lastName,
			"phonenumber"->key.phonenumber)
			.executeInsert()
		}
	}
 
}

