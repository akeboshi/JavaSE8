#! /usr/local/bin/jjs

for (var k in $ENV) {
  print(k + "=" + $ENV[k])
}
