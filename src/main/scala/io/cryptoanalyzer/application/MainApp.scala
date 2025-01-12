package io.cryptoanalyzer.application

import io.cryptoanalyzer.application.ports.{KafkaConsumerPort, KafkaProducerPort}
import io.cryptoanalyzer.infrastructure.config.{AppConfig, AppConfigLayer, KafkaConfig}
import io.cryptoanalyzer.infrastructure.kafka.{ConsumerLayer, KafkaConsumerAdapter, KafkaProducerAdapter, ProducerLayer}
import zio._

object MainApp extends ZIOAppDefault {
//  private val kafkaProducerPortLayer: ZLayer[Any, Throwable, KafkaProducerPort[Task]] =
//  ProducerLayer.live >>> KafkaProducerAdapter.layer
//
//  private val kafkaConsumerPortLayer: ZLayer[Any, Throwable, KafkaConsumerPort[Task]] =
//    ConsumerLayer.live >>> KafkaConsumerAdapter.layer
//
//  override def run: ZIO[Any, Throwable, Unit] = {
//    val topic = "test-topic"
//    (for {
//      // 1. Odpalamy konsumenta w tle, żeby słuchał topicu
//      _ <- ZIO.serviceWithZIO[KafkaConsumerPort[Task]](_.consume(topic)).forkDaemon
//
//      // 2. Wysyłamy przykład wiadomości
//      kafkaPort <- ZIO.service[KafkaProducerPort[Task]]
//      _ <- Console.printLine("Sending message to Kafka...")
//      _ <- kafkaPort.sendMessage(topic, "myKey", "Hello from ZIO Kafka!")
//      _ <- Console.printLine("Message sent!")
//
//      // 3. Żeby zobaczyć efekt, odczekajmy chwilę (np. 5s),
//      //    bo consumer będzie wypisywał w tle
//      _ <- ZIO.sleep(20.seconds)
//
//    } yield ()).provideLayer(kafkaProducerPortLayer ++ kafkaConsumerPortLayer)
//  }
private val kafkaConfigLayer: ZLayer[Any, Config.Error, KafkaConfig] =
ZLayer.fromZIO(
  ZIO.config[KafkaConfig](KafkaConfig.config)
)

val program: ZIO[KafkaConfig, Nothing, Unit] = for {
  config <- ZIO.service[KafkaConfig]
  _ <- ZIO.succeed(println(s"Spark Master: ${config.topic}"))
} yield ()

  override def run: ZIO[Any, Any, Any] =
    program.provideLayer(kafkaConfigLayer)
}