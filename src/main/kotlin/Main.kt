import kotlin.math.pow
import kotlin.math.sqrt


class Complex {
    var re = 0.0
    var im = 0.0

    constructor(re: Double, im: Double = 0.0) {
        this.re = re
        this.im = im
    }

    constructor(re: Float, im: Float = 0.0f) {
        this.re = re.toDouble()
        this.im = im.toDouble()
    }

    constructor(re: Int, im: Int = 0) {
        this.re = re.toDouble()
        this.im = im.toDouble()
    }

    constructor() {
        this.re = 0.0
        this.im = 0.0
    }

    fun Abs(): Double {
        return sqrt(this.re.pow(2) + this.im.pow(2))
    }

    fun Conjugate(): Complex {
        return Complex(this.re, -this.im)
    }

    fun ToString(): String {
        val reStr = (if (this.re - this.re.toInt() == 0.0) this.re.toInt() else this.re).toString()
        val imStr = (if (this.im - this.im.toInt() == 0.0) this.im.toInt() else this.im).toString()
        if ((this.re != 0.0) && (this.im != 0.0)) {
            if (this.im >= 0)
                return reStr + " + " + imStr + "j"
            else
                return reStr + " - " + imStr.replace("-", "") + "j"
        } else {
            if (this.re != 0.0)
                return reStr
            else {
                if (this.im != 0.0)
                    return imStr + "j"
                else
                    return "0"
            }
        }
    }

    // +
    operator fun plus(other: Complex): Complex {
        return Complex(this.re + other.re, this.im + other.im)
    }

    operator fun plus(double: Double): Complex {
        return Complex(this.re + double, this.im)
    }

    operator fun plus(float: Float): Complex {
        return Complex(this.re + float, this.im)
    }

    operator fun plus(int: Int): Complex {
        return Complex(this.re + int, this.im)
    }

    fun plusAssign(other: Complex): Complex {
        return Complex(this.re + other.re, this.im + other.im)
    }

    fun plusAssign(double: Double): Complex {
        return Complex(this.re + double, this.im)
    }

    fun plusAssign(float: Float): Complex {
        return Complex(this.re + float, this.im)
    }

    fun plusAssign(int: Int): Complex {
        return Complex(this.re + int, this.im)
    }

    // -
    operator fun minus(other: Complex): Complex {
        return Complex(this.re - other.re, this.im - other.im)
    }

    operator fun minus(double: Double): Complex {
        return Complex(this.re - double, this.im)
    }

    operator fun minus(float: Float): Complex {
        return Complex(this.re - float, this.im)
    }

    operator fun minus(int: Int): Complex {
        return Complex(this.re - int, this.im)
    }

    fun minusAssign(other: Complex): Complex {
        return Complex(this.re - other.re, this.im - other.im)
    }

    fun minusAssign(double: Double): Complex {
        return Complex(this.re - double, this.im)
    }

    fun minusAssign(float: Float): Complex {
        return Complex(this.re - float, this.im)
    }

    fun minusAssign(int: Int): Complex {
        return Complex(this.re - int, this.im)
    }

    // *
    operator fun times(other: Complex): Complex {
        return Complex(this.re * other.re - this.im * other.im, this.re * other.im + this.im * other.re)
    }

    operator fun times(double: Double): Complex {
        return Complex(this.re * double, this.im * double);
    }

    operator fun times(float: Float): Complex {
        return Complex(this.re * float, this.im * float);
    }

    operator fun times(int: Int): Complex {
        return Complex(this.re * int, this.im * int);
    }

    fun timesAssign(other: Complex): Complex {
        return Complex(this.re * other.re - this.im * other.im, this.re * other.im + this.im * other.re)
    }

    fun timesAssign(double: Double): Complex {
        return Complex(this.re * double, this.im * double);
    }

    fun timesAssign(float: Float): Complex {
        return Complex(this.re * float, this.im * float);
    }

    fun timesAssign(int: Int): Complex {
        return Complex(this.re * int, this.im * int);
    }

    // /
    operator fun div(other: Complex): Complex {
        val resRe = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im)
        val resIm = (other.re * this.im - this.re * other.im) / (other.re * other.re + other.im * other.im)
        return Complex(resRe, resIm)
    }

    operator fun div(double: Double): Complex {
        return Complex(this.re / double, this.im / double)
    }

    operator fun div(float: Float): Complex {
        return Complex(this.re / float, this.im / float)
    }

    operator fun div(int: Int): Complex {
        return Complex(this.re / int, this.im / int)
    }

    fun divAssign(other: Complex): Complex {
        val resRe = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im)
        val resIm = (other.re * this.im - this.re * other.im) / (other.re * other.re + other.im * other.im)
        return Complex(resRe, resIm)
    }

    fun divAssign(double: Double): Complex {
        return Complex(this.re / double, this.im / double)
    }

    fun divAssign(float: Float): Complex {
        return Complex(this.re / float, this.im / float)
    }

    fun divAssign(int: Int): Complex {
        return Complex(this.re / int, this.im / int)
    }
}

fun main(args: Array<String>) {
    println("Hello World!")
    val z = Complex(5, 3)
    val z1 = Complex(5.1, 3.1)
    println(z.ToString())
    println(z1.ToString())
    val z2 = z + z1
    println(z2.ToString())
    val z3 = z1 - z
    println(z3.ToString())
    var z0 = Complex()
    println(z0.ToString())
    z0 += z1
    println(z0.ToString())
    z0 -= z
    println(z0.ToString())
}