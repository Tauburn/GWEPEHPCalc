package generators

import play.api.libs.json.{Json, Writes}

/**
  * Created by david on 19/06/16.
  */
case class TripleStats(major: String,
                       majorValue: Int,
                       minorOne: String,
                       minorTwo: String,
                       minorValue: Int)

object TripleStats {
  implicit val tripleStatsWrites = new Writes[TripleStats] {
    def writes(tripleStats: TripleStats) = Json.obj(
      tripleStats.major -> tripleStats.majorValue,
      tripleStats.minorOne -> tripleStats.minorValue,
      tripleStats.minorTwo -> tripleStats.minorValue
    )
  }
}

case class QuadStats(majorNameOne: String,
                     majorNameTwo: String,
                     majorValue: Int,
                     minorNameOne: String,
                     minorNameTwo: String,
                     minorValue: Int)

object QuadStats {
  implicit val quadStatsWrites = new Writes[QuadStats] {
    def writes(quadStats: QuadStats) = Json.obj(
      quadStats.majorNameOne -> quadStats.majorValue,
      quadStats.majorNameTwo -> quadStats.majorValue,
      quadStats.minorNameOne -> quadStats.minorValue,
      quadStats.minorNameTwo -> quadStats.minorValue
    )
  }
}

case class CelestialStats(attrValue: Int)

object CelestialStats {
  implicit val celestialStatsWrites = new Writes[CelestialStats] {
    def writes(celestialStats: CelestialStats) = Json.obj(
      "power" -> celestialStats.attrValue,
      "precision" -> celestialStats.attrValue,
      "toughness" -> celestialStats.attrValue,
      "vitality" -> celestialStats.attrValue,
      "condition_damage" -> celestialStats.attrValue,
      "healing_power" -> celestialStats.attrValue,
      "ferocity" -> celestialStats.attrValue
    )
  }
}

case class TypeStats(name: String,
                     tripleStats: Option[TripleStats] = None,
                     quadStats: Option[QuadStats] = None,
                     celestialStats: Option[CelestialStats] = None)

object TypeStats {
  implicit val typeStatsWrite = new Writes[TypeStats] {
    def writes(typeStats: TypeStats) = Json.obj(
      if(typeStats.tripleStats.isDefined) {
        typeStats.name -> TripleStats.tripleStatsWrites.writes(typeStats.tripleStats.get)
      } else if(typeStats.quadStats.isDefined){
        typeStats.name -> QuadStats.quadStatsWrites.writes(typeStats.quadStats.get)
      } else {
        typeStats.name -> CelestialStats.celestialStatsWrites.writes(typeStats.celestialStats.get)
      }
    )
  }
}

case class LevelStats(name: String,
                       stats: Seq[TypeStats])

object LevelStats {
  implicit val levelStatsWrite = new Writes[LevelStats] {
    def writes(levelStats: LevelStats) = Json.obj(
      levelStats.name -> levelStats.stats
    )
  }
}