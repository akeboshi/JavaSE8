#!/usr/local/bin/jjs

var age = +arguments[0]
if (arguments.length > 1) {
  print ("引数は一つのみ有効です。")
  exit();
}

if ((age == null || isNaN(age)) && !isNaN($ENV.AGE)){
  age = +$ENV.AGE
}

while (isNaN(age)){
  age = +readLine('your age: ')
}

print("Next year, you will be ${age + 1}")
