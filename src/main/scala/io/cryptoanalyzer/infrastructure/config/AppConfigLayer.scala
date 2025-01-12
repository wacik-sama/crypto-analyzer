package io.cryptoanalyzer.infrastructure.config

import zio.config.ConfigOps
import zio.{Config, ZIO, ZLayer}

final case class AppConfig(
                            kafka: KafkaConfig,
                            spark: SparkConfig
                          )

object AppConfigLayer {
  val appConfig: Config[AppConfig] =
    (KafkaConfig.config zip SparkConfig.config).to[AppConfig]

  def live: ZLayer[Any, Config.Error, AppConfig] =
    ZLayer.fromZIO(
        ZIO.config[AppConfig](appConfig)
      )
}
