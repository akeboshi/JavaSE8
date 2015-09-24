#! /usr/local/bin/jjs
// 意図がよくわかりません。全て、java.lang.String
// castはHelloが表示される

var str = 'Hello, World'
print(str)
print(str.getClass())
var sub = str.substring(0,5)
print(sub)
print(sub.getClass())
var cast = java.lang.String.class.cast(sub)
print(cast)
print(cast.getClass())
