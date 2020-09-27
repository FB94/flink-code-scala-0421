package com.atguigu.day02

import com.atguigu.day02.util.{SensorReading, SensorSource}
import org.apache.flink.streaming.api.scala._

object MapExample {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val stream: DataStream[SensorReading] = env.addSource(new SensorSource)

    stream
      .map(r => r.id)
      .print()



  }

}
