#! /usr/local/bin/jjs
// IDEの恩恵を使ってないのでめんどくさい。
// ただ、ちゃんとclassを作らなくて良いのでその意味では書きやすい？

var zoneDate = java.time.ZonedDateTime

var dateObj = zoneDate.now()
print(dateObj)
print(dateObj.getDayOfMonth())
