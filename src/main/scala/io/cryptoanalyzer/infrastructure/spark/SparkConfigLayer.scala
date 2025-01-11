package io.cryptoanalyzer.infrastructure.spark

import io.cryptoanalyzer.infrastructure.spark.model.SparkConfig
import zio.ZLayer

object SparkConfigLayer {
  val live: ZLayer[Any, Throwable, SparkConfig] =
    ZLayer.succeed(SparkConfig(appName = "MySparkApp", master = "local"))
}
