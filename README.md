# copy-dynamodb-spark-scala
Copy DynamoDB

Requirements:

- spark-dynamodb_2.11-1.0.4.jar

EMR Add Step

```bash

JOB_STEPS='[
  {
    "Type": "Spark",
    "Name": "Copy DynamoDB",
    "ActionOnFailure": "CONTINUE",
    "Args": [
      "--deploy-mode","cluster",
      "--master","yarn",
      "--jars","/usr/lib/spark-dynamodb_2.11-1.0.4.jar",
      "--class","br.com.viaconsulting.CopyDynamoDB",
      "s3://xxxxxx/copy-dynamodb_2.11-0.1.0.jar.jar",
      "source-dynamodb-table",
      "target-dynamodb-table"
    ]
  }
]'

aws emr add-steps --cluster-id XXXXXXXX --steps "${JOB_STEPS}"

```
