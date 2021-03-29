package example

import shapeless.tag
import shapeless.tag.@@

object DayOfWeekAsInt {
  protected sealed trait DayOfWeekTag

  type DayOfWeek = Int @@ DayOfWeekTag

  val Monday: DayOfWeek = tag[DayOfWeekTag][Int](1)
  val Tuesday: DayOfWeek = tag[DayOfWeekTag][Int](2)
  val Wednesday: DayOfWeek = tag[DayOfWeekTag][Int](3)
  val Thursday: DayOfWeek = tag[DayOfWeekTag][Int](4)
  val Friday: DayOfWeek = tag[DayOfWeekTag][Int](5)
  val Saturday: DayOfWeek = tag[DayOfWeekTag][Int](6)
  val Sunday: DayOfWeek = tag[DayOfWeekTag][Int](7)
}
