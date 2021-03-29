package example

import org.apache.spark.sql.{Dataset, SparkSession}

object Application {
  def main(args: Array[String]): Unit = tryDayOfWeekAsString()

  private val spark: SparkSession = SparkSession
    .builder()
    .appName("tagged-types")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._

  private def tryDayOfWeekAsInt(): Unit = {
    val ds1: Dataset[ThingInt] = List(
      (1, DayOfWeekAsInt.Monday),
      (2, DayOfWeekAsInt.Wednesday),
      (3, DayOfWeekAsInt.Friday)
    ).toDF("id", "dayOfWeek").as[ThingInt]

    val path: String = "spark-data-int"

    ds1.write.mode("overwrite").parquet(path)

    val ds2: Dataset[ThingInt] = spark.read.parquet(path).as[ThingInt]

    ds2.show(3, false)
  }

  private def tryDayOfWeekAsString(): Unit = {
    val ds1: Dataset[ThingString] = List(
      (1, DayOfWeekAsString.Monday),
      (2, DayOfWeekAsString.Wednesday),
      (3, DayOfWeekAsString.Friday)
    ).toDF("id", "dayOfWeek").as[ThingString]

    val path: String = "spark-data-string"

    ds1.write.mode("overwrite").parquet(path)

    val ds2: Dataset[ThingString] = spark.read.parquet(path).as[ThingString]

    ds2.show(3, false)
  }
}
