package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by david on 09/06/16.
  */
class BasicController extends Controller {
  def index = Action {

    Ok(views.html.calculator())
  }

}
