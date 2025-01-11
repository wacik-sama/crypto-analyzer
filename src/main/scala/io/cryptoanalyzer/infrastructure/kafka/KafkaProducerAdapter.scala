package io.cryptoanalyzer.infrastructure.kafka

import io.cryptoanalyzer.application.ports.KafkaProducerPort
import zio._
import zio.kafka.producer._
import zio.kafka.serde.Serde

final class KafkaProducerAdapter(producer: Producer)
  extends KafkaProducerPort[Task] {

  override def sendMessage(topic: String, key: String, value: String): Task[Unit] =
    producer
      .produce(
        topic = topic,
        key = key,
        value = value,
        keySerializer   = Serde.string,
        valueSerializer = Serde.string
      )
      .unit
}

object KafkaProducerAdapter {
  val layer: ZLayer[Producer, Nothing, KafkaProducerPort[Task]] =
    ZLayer.fromFunction(new KafkaProducerAdapter(_))
}
