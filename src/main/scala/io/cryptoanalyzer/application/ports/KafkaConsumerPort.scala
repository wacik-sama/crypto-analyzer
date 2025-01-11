package io.cryptoanalyzer.application.ports

trait KafkaConsumerPort[F[_]] {
  def consume(topic: String): F[Unit]
}
