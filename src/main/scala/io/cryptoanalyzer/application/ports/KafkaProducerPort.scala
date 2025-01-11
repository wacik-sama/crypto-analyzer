package io.cryptoanalyzer.application.ports

trait KafkaProducerPort[F[_]] {
  def sendMessage(topic: String, key: String, value: String): F[Unit]
}
