package connector

import scalaj.http.{Http, HttpRequest, HttpResponse}

/**
  * Created by david on 09/06/16.
  */
object ApiConnector extends ApiConnector{

}

trait ApiConnector {

  def getItem(): String = {
    val response: HttpResponse[String] = Http("https://api.guildwars2.com/v2/items/5777").asString
    print(response.body)
    response.body
  }
}
