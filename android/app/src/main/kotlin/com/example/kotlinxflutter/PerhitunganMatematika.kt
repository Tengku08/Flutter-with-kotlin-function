package com.example.kotlinxflutter

internal class PerhitunganMatematika {
    fun rumus(Inputan: String): String {
        val exp: String = Inputan
        var num: String = ""
        var symbol: Char = '+'
        var result: Int = 0

        for(i in exp)
        {
            if(i in '0'..'9')
                num += i
            else
            {
                if(symbol == '+')
                    result += Integer.parseInt(num)
                else if(symbol == '-')
                    result -= Integer.parseInt(num)
                else if(symbol == '*')
                    result *= Integer.parseInt(num)
                else if(symbol == '/')
                    result /= Integer.parseInt(num)

                num=""
                symbol = i
            }
        }

        //To calculate the divide by 4 ( result/4 ) in this case
        if(symbol == '+')
            result += Integer.parseInt(num)
        else if(symbol == '-')
            result -= Integer.parseInt(num)
        else if(symbol == '*')
            result *= Integer.parseInt(num)
        else if(symbol == '/')
            result /= Integer.parseInt(num)
        return result.toString();

    }
}