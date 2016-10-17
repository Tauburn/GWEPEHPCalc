//package connector
//
//import scala.util.parsing.json.JSONObject
//import scalaj.http.{Http, HttpRequest, HttpResponse}
//
///**
//  * Created by david on 09/06/16.
//  */
//object ApiConnector extends ApiConnector{
//
//}
//
//trait ApiConnector {
//
//  def getItem(id: String): String = {
//    val response: HttpResponse[HttpResponse] = Http("https://api.guildwars2.com/v2/items/" + id).asString
//    JSONObject(response.body)
//  }
//}
