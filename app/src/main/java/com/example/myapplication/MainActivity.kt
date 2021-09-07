package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.util.toRange
import androidx.preference.PreferenceManager
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import java.lang.Exception
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity() {
    var nStr: String = ""
    val nList = ArrayList<Double>() // arraylist to store numbers
    val oList = ArrayList<Char>() // arraylist to store operations
    lateinit var formula: TextView
    lateinit var answer : TextView
    lateinit var mAdView: AdView
    var random = 1.0
    var OnOff=true
    var zyuunobaisuu=false
    var kotae:Boolean=false
    var b:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //広告
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.Banner)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var button0 = findViewById<ImageButton>(R.id.button0)
        var button1 = findViewById<ImageButton>(R.id.button1)
        var button2 = findViewById<ImageButton>(R.id.button2)
        var button3 = findViewById<ImageButton>(R.id.button3)
        var button4 = findViewById<ImageButton>(R.id.button4)
        var button5 = findViewById<ImageButton>(R.id.button5)
        var button6 = findViewById<ImageButton>(R.id.button6)
        var button7 = findViewById<ImageButton>(R.id.button7)
        var buttonQ = findViewById<ImageButton>(R.id.percent)
        var buttonX = findViewById<ImageButton>(R.id.buttonX)
        var buttonS = findViewById<ImageButton>(R.id.point)
        var buttonI = findViewById<ImageButton>(R.id.equel)  //equel
        var buttonC = findViewById<ImageButton>(R.id.buttonC)
        var buttonP = findViewById<ImageButton>(R.id.plus) //plus
        var buttonW = findViewById<ImageButton>(R.id.divided) //divided
        var buttonZ = findViewById<ImageButton>(R.id.times) //times
        var buttonM = findViewById<ImageButton>(R.id.minus) //minus
        var button8 = findViewById<ImageButton>(R.id.button8)
        var button9 = findViewById<ImageButton>(R.id.button9)
        formula = findViewById<TextView>(R.id.formula)
        answer= findViewById<TextView>(R.id.answer)
        var settingBotton = findViewById<ImageButton>(R.id.settingBotton)

        settingBotton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.setting, Setting())
                .addToBackStack(null)
                .commit()
        }
        button0.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}0"
            nStr += "0"
        }

        button1.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}1"
            nStr += "1"
        }

        button2.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}2"
            nStr += "2"
        }

        button3.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}3"
            nStr += "3"
        }

        button4.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}4"
            nStr += "4"
        }

        button5.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}5"
            nStr += "5"
        }

        button6.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}6"
            nStr += "6"
        }

        button7.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}7"
            nStr += "7"
        }

        button8.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}8"
            nStr += "8"
        }

        button9.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}9"
            nStr += "9"
        }

        buttonS.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}."
            nStr += "."
        }



        buttonZ.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}*"
            addlist(nStr, '*')
            nStr = ""
        }

        buttonW.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}÷"
            addlist(nStr, '/')
            nStr = ""
        }

        buttonP.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}+"
            addlist(nStr, '+')
            nStr = ""
        }


        buttonM.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}-"
            addlist(nStr, '-')
            nStr = ""
        }

        buttonQ.setOnClickListener {
            if(kotae==true){
                formula.text=b
                answer.text=""
                kotae=false     }
            formula.text = "${formula.text}%"
            addlist(nStr, '*')
            nStr = "0.01"


        }

        //buttonDEL.setOnClickListener{
        //var formulaStr=formula.text.toString()
        //if(!formulaStr.isEmpty()){
        //formula.text = formulaStr.subSequence(0,formulaStr.lastIndex)
        //}
        //if(!nStr.isEmpty()){
        //nStr=nStr.substring(0,nStr.lastIndex)
        //}
        //}

        buttonC.setOnClickListener {
            formula.text = ""
            answer.text=""
            b=""
            nStr = ""
            nList.clear()
            oList.clear()
        }

        buttonI.setOnClickListener {
            formula.text = "${formula.text}="
            addlist(nStr)

            val mode = sharedPreferences.getString("mode", "increace")
            val LEVEL = sharedPreferences.getString("level", "wear")
            OnOff=sharedPreferences.getBoolean("OnOff",true)
            if (mode != "OFF" && LEVEL != "OFF") {
                if (mode == "increace") {
                    random = when (LEVEL) {
                        "wear" -> 1.05
                        "normal" -> 1.1
                        "ultimate"->2.0
                        else -> 1.5
                    }
                } else {
                    random = when (LEVEL) {
                        "wear" -> 0.95
                        "normal" -> 0.9
                        "ultimate"->0.3
                        else -> ThreadLocalRandom.current().nextDouble(0.7, 0.8)
                    }
                }
            }else random=1.0



            var result = calcualte()
            if (result % 1.0 == 0.0) {
                var a: Int = result.toInt()
                b= a.toString()
                if(zyuunobaisuu==true){
                    b=b.dropLast(1)
                    b=b+"0"
                }
                answer.text=b
                nStr = b
            } else {
                b= result.toString()
                if(zyuunobaisuu==true){
                    b=b.dropLast(1)
                    b=b+"0"
                }
                answer.text=b
                nStr = b
            }
            nList.clear()
            oList.clear()
            kotae=true
        }






        buttonX.setOnClickListener {
            if (nStr.length == 1 && formula.length() == 1) {
                var a: Int = nStr.toInt()
                var b = a * (-1)
                var result = b.toString()
                formula.text = result
                nList.clear()
                nStr = result
            }
        }


    } // end fun onCreate


    fun addlist(str: String, ope: Char) {
        try {
            var num = str.toDouble()
            nList.add(num)
            if (ope != '=') oList.add(ope)
        } catch (e: Exception) {
            formula.text = "Numeric error"
        }
    }

    fun addlist(str: String) {
        try {
            var num = str.toDouble()
            nList.add(num)
        } catch (e: Exception) {
            formula.text = "Numeric errow"
        }

    }

    fun calcualte(): Double {

        var i = 0
        while (i < oList.size) {
            if (oList.get(i) == '*' || oList.get(i) == '/') {
                var result =
                    if (oList.get(i) == '*') nList.get(i) * nList.get(i + 1) else nList.get(i) / nList.get(
                        i + 1
                    )
                nList.set(i, result)
                nList.removeAt(i + 1)
                oList.removeAt(i)
                i--
            } else if (oList.get(i) == '-') {
                oList.set(i, '+')
                nList.set(i + 1, nList.get(i + 1) * -1)
            }
            i++
        }

        var result = 0.0
        for (i in nList) {
            result += i
        }
        if(result%10.0==0.0&&oList.size>1&&oList.contains('*')&&(oList.contains('+')||oList.contains('+'))&&OnOff==true){
            zyuunobaisuu=true
        }else zyuunobaisuu=false


        if(result%1.0==0.0) {
            result=result*random
            result=result.toInt().toDouble()
            return result

        }else return result * random // end fun calcualte

    }

}