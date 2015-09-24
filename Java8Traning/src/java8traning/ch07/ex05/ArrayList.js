#! /usr/local/bin/jjs

function newArrayList () {
  var arr = new (Java.extend(java.util.ArrayList))
  {
    add: function add(x) {
      print ('Adding ' + x)
      return Java.super(arr).add(x)
    }
  }
  return arr
}

var arr1 = newArrayList()
var arr2 = newArrayList()
arr1.add("foo")
arr1.add("foo2")
arr2.add("bar")

if (arr1.get(0).equals("foo")) print("ok")
if (arr1.get(1).equals("foo2")) print("ok")
if (arr2.get(0).equals("bar")) print("ok")
if (arr1.size() == 2) print("ok")
if (arr2.size() == 1) print("ok")

