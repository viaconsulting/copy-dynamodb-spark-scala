organization := "br.com.viaconsulting"
name := "copy-dynamodb"
version := "0.0.4"
scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
    "org.apache.spark"    %% "spark-core"     % "2.4.5" ,
    "org.apache.spark"    %% "spark-sql"      % "2.4.5" ,
    "com.audienceproject" %% "spark-dynamodb" % "1.0.4" ,
)
