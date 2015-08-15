package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action { implicit req =>
    Ok(views.html.index("Your new application is ready."))
  }
}


import org.json4s._
import org.json4s.native.JsonMethods._
import com.github.tototoshi.play2.json4s.native._

class Phrase extends Controller with Json4s {
  implicit val formats = DefaultFormats

  def list = Action { implicit request =>
    Ok(Extraction.decompose(Map("pouetpouet" -> 12)))
  }
}



