/*
 * File: AsteroidTest copy.scala
 * Project: tests
 * Created Date: Friday January 21st 2022
 * Author: Ronan (ronan.lashermes@inria.fr)
 * -----
 * Last Modified: Tuesday, 25th January 2022 1:48:34 pm
 * Modified By: Ronan (ronan.lashermes@inria.fr>)
 * -----
 * Copyright (c) 2022 INRIA
 */
package tests

import spinal.core._
import spinal.sim._
import spinal.core.sim._
import debug._


object DebugMemoryTest {

    def main(args: Array[String]): Unit = {
        // SimConfig.withWave.doSim(new DebugMemory()(XlenConfig(32))){dut =>
        SimConfig.withWave.doSim(new Debug()){dut =>
            //Fork a process to generate the reset and the clock on the dut
            dut.clockDomain.forkStimulus(period = 10)

            dut.io.in1 #= true
            dut.io.in2 #= 5

            for(i <- 0 to 100) {
                dut.clockDomain.waitRisingEdge()
            }

        }
    }
}