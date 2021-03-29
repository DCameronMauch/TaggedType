package example

import shapeless.tag
import shapeless.tag.@@

object DayOfWeekAsString {
  protected sealed trait DayOfWeekTag

  type DayOfWeek = String @@ DayOfWeekTag

  val Monday: DayOfWeek = tag[DayOfWeekTag][String]("Monday")
  val Tuesday: DayOfWeek = tag[DayOfWeekTag][String]("Tuesday")
  val Wednesday: DayOfWeek = tag[DayOfWeekTag][String]("Wednesday")
  val Thursday: DayOfWeek = tag[DayOfWeekTag][String]("Thursday")
  val Friday: DayOfWeek = tag[DayOfWeekTag][String]("Friday")
  val Saturday: DayOfWeek = tag[DayOfWeekTag][String]("Saturday")
  val Sunday: DayOfWeek = tag[DayOfWeekTag][String]("Sunday")
}
