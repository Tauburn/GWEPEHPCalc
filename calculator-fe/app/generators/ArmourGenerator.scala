package generators

import play.api.libs.json.JsValue

/**
  * Created by david on 13/06/16.
  */
object ArmourGenerator extends ArmourGenerator

trait ArmourGenerator {
  def generate(arg: JsValue): Unit = {
    


  }
}