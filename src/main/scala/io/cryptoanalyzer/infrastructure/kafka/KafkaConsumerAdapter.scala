package io.cryptoanalyzer.infrastructure.kafka

import io.cryptoanalyzer.application.ports.KafkaConsumerPort
import zio._
import zio.kafka.consumer._
import zio.kafka.serde._

final class KafkaConsumerAdapter(consumer: Consumer) extends KafkaConsumerPort[Task] {
  override def consume(topic: String): Task[Unit] = {
    consumer.consumeWith(
      subscription = Subscription.topics(topic),
      keyDeserializer = Serde.string,
      valueDeserializer = Serde.string
    ) { record =>
      Console.printLine(
        s"Consumed message with key: and value: ${record.value()}"
      ).orDie
    }
  }
}

object KafkaConsumerAdapter {
  val layer: ZLayer[Consumer, Nothing, KafkaConsumerPort[Task]] =
    ZLayer.fromFunction(new KafkaConsumerAdapter(_))
}