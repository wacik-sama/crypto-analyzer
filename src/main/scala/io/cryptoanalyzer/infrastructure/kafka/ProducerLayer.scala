package io.cryptoanalyzer.infrastructure.kafka

import zio._
import zio.kafka.producer._
import zio.kafka.producer.ProducerSettings

object ProducerLayer {
  val live: ZLayer[Any, Throwable, Producer] =
    ZLayer.scoped {
      Producer.make(
        settings = ProducerSettings(List("localhost:29092"))
      )
    }
}
