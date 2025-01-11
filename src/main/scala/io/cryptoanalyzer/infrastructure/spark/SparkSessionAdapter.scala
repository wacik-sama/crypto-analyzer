package io.cryptoanalyzer.infrastructure.spark

import io.cryptoanalyzer.application.ports.SparkSessionPort
import io.cryptoanalyzer.infrastructure.spark.model.SparkConfig
import org.apache.spark.sql.SparkSession
import zio.{Task, ZIO, ZLayer}

final class SparkSessionAdapter(config: SparkConfig)
  extends SparkSessionPort[Task] {

  private lazy val session: SparkSession =
    SparkSession.builder()
      .appName(config.appName)
      .master(config.master)
      .getOrCreate()

  override def getSession: Task[SparkSession] =
    ZIO.succeed(session)

  override def stopSession: Task[Unit] =
    ZIO.succeed(session.stop())
}



object SparkSessionAdapter {
  val layer: ZLayer[SparkConfig, Nothing, SparkSessionPort[Task]] =
    ZLayer.fromFunction(new SparkSessionAdapter(_))
}
