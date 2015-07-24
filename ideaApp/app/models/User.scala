package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class User(
email:String,
password: String,
confirmpassword:String,
firstName:String,
lastName:String,
phonenumber:String
)


object User {


	val parser: RowParser[User] = {
		get[String]("datause.email") ~ 
		get[String]("datause.password") ~ 
		get[String]("datause.confirmpassword") ~ 
		get[String]("datause.firstName") ~
		get[String]("datause.lastName") ~
		get[String]("datause.phonenumber") map {
	    	case email ~ password ~ confirmpassword ~ firstName ~ lastName ~ phonenumber
	    		=> User(email,password,confirmpassword,firstName,lastName,phonenumber)
	    	}
	}
	
	

	//def delete: Unit = {
		//DB.withConnection { implicit c =>
		//SQL("delete from users where firstName ='swati'").executeUpdate()
		//}
  
    def findAll: List[User] = {
        DB.withConnection { implicit connection =>
            SQL("SELECT * FROM datause").as(parser *)
        }
    }


def add(key: User) {
	DB.withConnection{  implicit c=> 
  	SQL("insert into datause values({email},{password},{confirmpassword}, {firstName},{lastName},{phonenumber})").on
  	('email-> key.email,'password->key.password,
      'confirmpassword -> key.confirmpassword,
      'firstName-> key.firstName,
      'lastName -> key.lastName,
      'phonenumber->key.phonenumber).executeUpdate()
}
 

  }

