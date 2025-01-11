package io.cryptoanalyzer.application.ports

import org.apache.spark.sql.SparkSession

trait SparkSessionPort[F[_]] {
  def getSession: F[SparkSession]
  def stopSession: F[Unit]
}
