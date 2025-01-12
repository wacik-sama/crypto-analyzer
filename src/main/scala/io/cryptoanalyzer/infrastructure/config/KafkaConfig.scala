package io.cryptoanalyzer.infrastructure.config

import zio.Config
import zio.config.magnolia.deriveConfig

case class KafkaConfig(
                        bootstrapServers: String,
                        topic: String,
                        groupId: String
                      )

object KafkaConfig {
  val config: Config[KafkaConfig] =
  deriveConfig[KafkaConfig].nested("KafkaConfig")
}
