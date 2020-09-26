package com.atguigu.day01

import org.apache.flink.streaming.api.scala._

object WordCountCromSocket {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val stream = env.socketTextStream("hadoop105", 9999, '\n')

    stream
      .flatMap(r => r.split(" "))
      .map(r => (r, 1))
      .keyBy(r => r._1)
      .sum(1)
      .print()

    env.execute()
  }

}
