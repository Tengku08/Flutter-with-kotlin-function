package com.example.kotlinxflutter

import io.flutter.embedding.android.FlutterActivity
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/merge"

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            if (call.method == "PiCalculator") {
                val startTime = System.currentTimeMillis()
                val calc = PiCalculator()
                var i = 0
                var arrayTime = arrayOf<String>()
                val numIters = 100
                while (i < numIters) {
                    val startTimeMini = System.currentTimeMillis()

                    calc.getOneByPi(1000000)
//                calc.mathPow(10000000)
                    i += 1
                    val endTimeMini = System.currentTimeMillis()
                    val resultTime = endTimeMini - startTimeMini
                    arrayTime = append(arrayTime, resultTime.toString())
                }
                println("Detail Execution time")
                arrayTime.forEach { println(it) }

                val endTime = System.currentTimeMillis()
                val iterTime = (endTime - startTime)
                val hasilAkhir = (endTime - startTime)
                result.success(hasilAkhir)
            }else if (call.method == "Perhitungan") {
                println("Print dari kotlin")
                val maths = PerhitunganMatematika()
                val inputan:String ? = call.argument("inputan");

                val hasil = inputan?.let { maths.rumus(it) };
                result.success(hasil);
            } else {
                result.notImplemented()
            }
        }
    }
}
