
package debug

import spinal.core._

class Debug() extends Component {
    val io = new Bundle {
        // val in1 = in(UInt(5 bits))
        val in1 = in(Bool())
        val in2 = in(UInt(5 bits))
        val out1 = out(UInt(5 bits))
    }

    val out_reg = Reg(UInt(5 bits)) init 0
    io.out1 := out_reg

    // val b = Bool()
    // b := (io.in1 === 1)
    // switch(io.in1) {
    //     is(1) {
    when(io.in1) {
        // when(io.in2 === 1) {
        //     out_reg := 1
        // }
            switch(io.in2) {
                is(1) {
                    out_reg := 1
                }
            }
        // }
    }
    // .otherwise {
        
    // }
    // }
}