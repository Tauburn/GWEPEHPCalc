package generators

import java.io.PrintWriter

import play.api.libs.json._

/**
  * Created by david on 13/06/16.
  */
object ArmourGenerator {

  def main(args: Array[String]) {
    val exoticStats = buildExoStatSeq()
    val ascendedStats = buildAscendedStats()
    generate("app/data/leggings.json", exoticStats, ascendedStats)
  }

  val exoticTriMajor = 90
  val exoticTriMinor = 64
  val exoticQuaMajor = 77
  val exoticQuaMinor = 42
  val exoticCeleStat = 42

  val ascendTriMajor = 94
  val ascendTriMinor = 67
  val ascendQuaMajor = 81
  val ascendQuaMinor = 44
  val ascendCeleStat = 44

  val powe = "power"
  val prec = "precision"
  val toug = "toughness"
  val vita = "vitality"
  val conc = "concentration"
  val cond = "condition_damage"
  val expe = "expertise"
  val fero = "ferocity"
  val heal = "healing_power"

  def generate(fileName: String, exotics: Seq[TypeStats], ascended: Seq[TypeStats]): Unit = {

    val stats = Json.toJson(Seq(LevelStats("exotic", exotics), LevelStats("ascended", ascended)))
    new PrintWriter(fileName) {write(stats.toString()); close() }
    //Yes I know I've just done a convert to Json and the toString() but sod it! I learnt things :P
  }

  def createTripleStats(major: String, minorOne: String, minorTwo: String): TripleStats = {
    TripleStats(major, exoticTriMajor.toInt, minorOne, minorTwo, exoticTriMinor.toInt)
  }

  def buildExoStatSeq(): Seq[TypeStats] = {
    Seq(
      TypeStats("berserker", Some(TripleStats(powe, exoticTriMajor, prec, fero, exoticTriMinor))),
      TypeStats("zealot", Some(TripleStats(powe, exoticTriMajor, prec, heal, exoticTriMinor))),
      TypeStats("soldier", Some(TripleStats(powe, exoticTriMajor, toug, vita, exoticTriMinor))),
      TypeStats("valkyrie", Some(TripleStats(powe, exoticTriMajor, vita, fero, exoticTriMinor))),
      TypeStats("captain", Some(TripleStats(prec, exoticTriMajor, powe, toug, exoticTriMinor))),
      TypeStats("rampager", Some(TripleStats(prec, exoticTriMajor, powe, cond, exoticTriMinor))),
      TypeStats("assassin", Some(TripleStats(prec, exoticTriMajor, powe, fero, exoticTriMinor))),
      TypeStats("knight", Some(TripleStats(toug, exoticTriMajor, prec, powe, exoticTriMinor))),
      TypeStats("cavalier", Some(TripleStats(toug, exoticTriMajor, powe, fero, exoticTriMinor))),
      TypeStats("nomad", Some(TripleStats(toug, exoticTriMajor, vita, heal, exoticTriMinor))),
      TypeStats("settler", Some(TripleStats(toug, exoticTriMajor, cond, heal, exoticTriMinor))),
      TypeStats("giver", Some(TripleStats(toug, exoticTriMajor, heal, conc, exoticTriMinor))),
      TypeStats("sentinel", Some(TripleStats(vita, exoticTriMajor, powe, toug, exoticTriMinor))),
      TypeStats("shaman", Some(TripleStats(vita, exoticTriMajor, cond, heal, exoticTriMinor))),
      TypeStats("sinister", Some(TripleStats(cond, exoticTriMajor, powe, prec, exoticTriMinor))),
      TypeStats("carrion", Some(TripleStats(cond, exoticTriMajor, powe, vita, exoticTriMinor))),
      TypeStats("rabid", Some(TripleStats(cond, exoticTriMajor, powe, toug, exoticTriMinor))),
      TypeStats("dire", Some(TripleStats(cond, exoticTriMajor, toug, vita, exoticTriMinor))),
      TypeStats("cleric", Some(TripleStats(heal, exoticTriMajor, powe, toug, exoticTriMinor))),
      TypeStats("magi", Some(TripleStats(heal, exoticTriMajor, vita, prec, exoticTriMinor))),
      TypeStats("apothecary", Some(TripleStats(heal, exoticTriMajor, toug, cond, exoticTriMinor))),
      TypeStats("magi", Some(TripleStats(heal, exoticTriMajor, vita, prec, exoticTriMinor))),

      TypeStats("commander", None, Some(QuadStats(powe, prec, exoticQuaMajor, toug, conc, exoticQuaMinor))),
      TypeStats("marauder", None, Some(QuadStats(powe, prec, exoticQuaMajor, vita, conc, exoticQuaMinor))),
      TypeStats("vigilant", None, Some(QuadStats(powe, toug, exoticQuaMajor, conc, expe, exoticQuaMinor))),
      TypeStats("crusader", None, Some(QuadStats(powe, toug, exoticQuaMajor, heal, fero, exoticQuaMinor))),
      TypeStats("wanderer", None, Some(QuadStats(powe, vita, exoticQuaMajor, toug, conc, exoticQuaMinor))),
      TypeStats("viper", None, Some(QuadStats(powe, cond, exoticQuaMajor, prec, expe, exoticQuaMinor))),
      TypeStats("trailblazer", None, Some(QuadStats(toug, cond, exoticQuaMajor, vita, expe, exoticQuaMinor))),
      TypeStats("minstrel", None, Some(QuadStats(toug, heal, exoticQuaMajor, vita, conc, exoticQuaMinor))),

      TypeStats("celestial", None, None, Some(CelestialStats(exoticCeleStat.toInt)))
    )
  }

  def buildAscendedStats(): Seq[TypeStats] = {
    Seq(
      TypeStats("berserker", Some(TripleStats(powe, ascendTriMajor, prec, fero, ascendTriMinor))),
      TypeStats("zealot", Some(TripleStats(powe, ascendTriMajor, prec, heal, ascendTriMinor))),
      TypeStats("soldier", Some(TripleStats(powe, ascendTriMajor, toug, vita, ascendTriMinor))),
      TypeStats("valkyrie", Some(TripleStats(powe, ascendTriMajor, vita, fero, ascendTriMinor))),
      TypeStats("captain", Some(TripleStats(prec, ascendTriMajor, powe, toug, ascendTriMinor))),
      TypeStats("rampager", Some(TripleStats(prec, ascendTriMajor, powe, cond, ascendTriMinor))),
      TypeStats("assassin", Some(TripleStats(prec, ascendTriMajor, powe, fero, ascendTriMinor))),
      TypeStats("knight", Some(TripleStats(toug, ascendTriMajor, prec, powe, ascendTriMinor))),
      TypeStats("cavalier", Some(TripleStats(toug, ascendTriMajor, powe, fero, ascendTriMinor))),
      TypeStats("nomad", Some(TripleStats(toug, ascendTriMajor, vita, heal, ascendTriMinor))),
      TypeStats("settler", Some(TripleStats(toug, ascendTriMajor, cond, heal, ascendTriMinor))),
      TypeStats("giver", Some(TripleStats(toug, ascendTriMajor, heal, conc, ascendTriMinor))),
      TypeStats("sentinel", Some(TripleStats(vita, ascendTriMajor, powe, toug, ascendTriMinor))),
      TypeStats("shaman", Some(TripleStats(vita, ascendTriMajor, cond, heal, ascendTriMinor))),
      TypeStats("sinister", Some(TripleStats(cond, ascendTriMajor, powe, prec, ascendTriMinor))),
      TypeStats("carrion", Some(TripleStats(cond, ascendTriMajor, powe, vita, ascendTriMinor))),
      TypeStats("rabid", Some(TripleStats(cond, ascendTriMajor, powe, toug, ascendTriMinor))),
      TypeStats("dire", Some(TripleStats(cond, ascendTriMajor, toug, vita, ascendTriMinor))),
      TypeStats("cleric", Some(TripleStats(heal, ascendTriMajor, powe, toug, ascendTriMinor))),
      TypeStats("magi", Some(TripleStats(heal, ascendTriMajor, vita, prec, ascendTriMinor))),
      TypeStats("apothecary", Some(TripleStats(heal, ascendTriMajor, toug, cond, ascendTriMinor))),
      TypeStats("magi", Some(TripleStats(heal, ascendTriMajor, vita, prec, ascendTriMinor))),

      TypeStats("commander", None, Some(QuadStats(powe, prec, ascendQuaMajor, toug, conc, ascendQuaMinor))),
      TypeStats("marauder", None, Some(QuadStats(powe, prec, ascendQuaMajor, vita, conc, ascendQuaMinor))),
      TypeStats("vigilant", None, Some(QuadStats(powe, toug, ascendQuaMajor, conc, expe, ascendQuaMinor))),
      TypeStats("crusader", None, Some(QuadStats(powe, toug, ascendQuaMajor, heal, fero, ascendQuaMinor))),
      TypeStats("wanderer", None, Some(QuadStats(powe, vita, ascendQuaMajor, toug, conc, ascendQuaMinor))),
      TypeStats("viper", None, Some(QuadStats(powe, cond, ascendQuaMajor, prec, expe, ascendQuaMinor))),
      TypeStats("trailblazer", None, Some(QuadStats(toug, cond, ascendQuaMajor, vita, expe, ascendQuaMinor))),
      TypeStats("minstrel", None, Some(QuadStats(toug, heal, ascendQuaMajor, vita, conc, ascendQuaMinor))),

      TypeStats("celestial", None, None, Some(CelestialStats(ascendCeleStat)))
    )
  }
}
