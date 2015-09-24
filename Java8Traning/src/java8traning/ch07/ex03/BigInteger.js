#! /usr/local/bin/jjs

// javascriptのtoStringが呼ばれる際に、javascriptのnumber型になる
// javascriptのnumber型は浮動小数点演算で、
// 整数で持てる値に限界がある。このため奇妙な表示になる。
// javascriptでtoStringを呼ぶ際に、BigIntegerのtoStringが呼ばれずに、
// javascriptのtoStringが呼ばれる。ここで、number型での表示になってしまう

var b = new java.math.BigInteger('1234567890987654321')
print(java.lang.String.valueOf(b.longValue()))
