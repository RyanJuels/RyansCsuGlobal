package com.example.mycalc

import android.util.Log

class evaluate {
    fun evalEquals(toEval: String): String {
        var result = ""
        try {
            val rpn: String = stringToRPN(toEval)
            val myList: List<String> = rpn.split(' ').filter { it != "" }
            val stack: ArrayDeque<Double> = ArrayDeque<Double>()
            for (item in myList) {
                val d: Double? = item.toDoubleOrNull()

                if (d != null) {
                    stack.addFirst(d)
                } else if (item !in "+-*/") {
                    throw IllegalArgumentException("$item is not a valid item")
                } else if (stack.size < 2) {
                    throw IllegalArgumentException("Stack contains too few operands")
                } else {
                    val d1 = stack.removeFirst()
                    val d2 = stack.removeFirst()
                    Log.i("", "Performing operation: d1: $d1, d2: $d2, item: $item")
                    stack.addFirst(
                        when (item) {
                            "+" -> d2 + d1
                            "-" -> d2 - d1
                            "*" -> d1 * d2
                            "/" -> d2 / d1
                            else -> {
                                Log.e("", "Failed to understand operator")
                            }
                        } as Double
                    )
                }
            }

            result = stack.first().toString()
        } catch (e: Exception) {
            Log.e("", "Exception: $e")
            result = "Err"
        }
        return result
    }

    //convert input string to reverse-polish notation
    private fun stringToRPN(expression: String): String {
        var output = ""
        val stack: ArrayDeque<String> = ArrayDeque<String>()
        val myList: List<String> = expression.split(' ').filter { it != "" }

        for (item in myList) {
            val d: Double? = item.toDoubleOrNull()

            if (d != null) {
                output += "$item " // space intentional
            } else if (")" == item) {
                //stack push
                while ("(" != stack.first()) {
                    //stack pop
                    output += stack.removeFirst() + " "
                }
                stack.removeFirst()
            } else if ("(" == item) {
                stack.addFirst(item)
            } else {
                while (!stack.isEmpty() && (getPriority(stack.first()) > getPriority(item))) {
                    output += stack.removeFirst() + " "
                }
                stack.addFirst(item)
            }
        }
        while (!stack.isEmpty()) {
            output += stack.removeFirst() + " "
        }
        Log.i("", "RPN string: $output")
        return output
    }

    private fun getPriority(op: String): Int {
        return when (op) {
            "(" -> 0
            "+", "-" -> 1
            "/", "*" -> 2
            else -> 3
        }
    }
}