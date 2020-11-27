package br.com.viaconsulting

import com.audienceproject.spark.dynamodb.implicits._
import org.apache.spark.sql.SparkSession

object CopyDynamoDB {

    def main(args: Array[String]): Unit = {

        // Spark Session
        val spark: SparkSession = SparkSession.builder.
            appName("Copy DynamoDB").
            getOrCreate()
        import spark.implicits._

        // Start
        println(s"Start ${java.time.LocalDateTime.now}")

        val sourceTable = "source-table"
        val targetTable = "target-table"

        val df = spark.read.dynamodb(sourceTable)

        // for (i <- 1 to 9) {
        //     val x = f"${i}%01d"
        //     val q = s"memberNumber >= '${x}00000000' and memberNumber <= '${x}99999999'"
        //     println(q)
        //     println(s"Start ${java.time.LocalDateTime.now}")
        //     df.filter(q).write.dynamodb(targetTable)
        //     println(s"End ${java.time.LocalDateTime.now}")
        // }

        df.write.dynamodb(targetTable)

        // End
        println(s"End ${java.time.LocalDateTime.now}")

    }
}