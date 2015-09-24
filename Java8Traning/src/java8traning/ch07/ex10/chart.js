#! /usr/local/bin/jjs -fx

function csv2Array(filePath) { //csvﾌｧｲﾙﾉ相対ﾊﾟｽor絶対ﾊﾟｽ
  var file = new java.io.File(filePath)
  var br = new java.io.BufferedReader(new java.io.FileReader(file))
  var arr = new Array()
  var line
  while((line = br.readLine()) != null) {
    arr.push(line.split(','))
  }
  br.close()
  return arr
}

var data  = csv2Array("./test.csv")

var piechartData = javafx.collections.FXCollections.observableArrayList()

for each(var d in data) {
  piechartData.add(new javafx.scene.chart.PieChart.Data(d[0],+d[1]))
}

chart = new javafx.scene.chart.PieChart(piechartData)
chart.setTitle("csv読み込み")
$STAGE.scene = new javafx.scene.Scene(chart, 600, 400)

