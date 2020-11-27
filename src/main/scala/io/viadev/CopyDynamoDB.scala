package br.com.viaconsulting

import com.audienceproject.spark.dynamodb.implicits._
import org.apache.spark.sql.SparkSession

object CopyDynamoDB {

    def main(args: Array[String]): Unit = {

        val sourceTable = args(0).toString
        val targetTable = args(1).toString

        // Spark Session
        val spark: SparkSession = SparkSession.builder.
            appName("Copy DynamoDB").
            getOrCreate()
        import spark.implicits._

        // Start
        println(s"Start ${java.time.LocalDateTime.now}")

        val df = spark.read.dynamodb(sourceTable)

        df.write.dynamodb(targetTable)

        // End
        println(s"End ${java.time.LocalDateTime.now}")

    }
}