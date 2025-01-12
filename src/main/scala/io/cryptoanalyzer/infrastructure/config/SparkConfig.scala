package io.cryptoanalyzer.infrastructure.config

import zio.Config
import zio.config.magnolia.deriveConfig

case class SparkConfig(
                        master: String,
                        appName: String,
                        batchInterval: Int
                      )

object SparkConfig {
  val config: Config[SparkConfig] =
    deriveConfig[SparkConfig].nested("SparkConfig")
}
