package com.iheart.thomas

package abtest
import model._
import _root_.play.api.libs.json._, Json.WithDefaultValues
import com.iheart.thomas.abtest.model.Abtest.Specialization

object Formats {
  implicit val jSpecialization: Format[Specialization] =
    new Format[Specialization] {
      def reads(json: JsValue): JsResult[Specialization] =
        json match {
          case JsString(name)
              if name == Specialization.MultiArmBanditConversion.toString =>
            JsSuccess(Specialization.MultiArmBanditConversion)
          case _ => JsError("Unrecognized Specialization")
        }

      def writes(o: Specialization): JsValue =
        JsString(o.toString)
    }
  val j = Json.using[WithDefaultValues]

  implicit val groupFormat = j.format[Group]

  implicit val groupRangeFormat = j.format[GroupRange]
  implicit val abtestFormat = j.format[Abtest]
  implicit val abtestSpecFormat = j.format[AbtestSpec]
  implicit val featureFormat = j.format[Feature]
  implicit val userGroupQueryFormat =
    j.format[UserGroupQuery]
  implicit val userGroupQueryResultFormat =
    j.format[UserGroupQueryResult]

}