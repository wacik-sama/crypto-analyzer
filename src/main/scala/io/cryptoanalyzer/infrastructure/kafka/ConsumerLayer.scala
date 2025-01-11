package io.cryptoanalyzer.infrastructure.kafka

import zio.ZLayer
import zio.kafka.consumer.{Consumer, ConsumerSettings}

object ConsumerLayer {
  val live: ZLayer[Any, Throwable, Consumer] =
    ZLayer.scoped {
      Consumer.make(
        ConsumerSettings(List("localhost:29092")).withGroupId("group").withProperty("auto.offset.reset", "earliest")
      )
    }
}
