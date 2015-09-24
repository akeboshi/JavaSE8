#! /usr/local/bin/jjs
// わかりません

function pipe () {
  var pb = new java.lang.ProcessBuilder
  var args = [] 
  for each (var arg in arguments) {
    args.push(arg)
  }
  pb.command(['/bin/sh','-c',args.join("|")])
  var p = pb.start()
  var br = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()))
  var str
  var result = []
  while((str = br.readLine()) != null) {
    result.push(str)
  }
  return result.join("\n")
}


print(pipe('cat pipeTest.txt', 'grep -v a', 'sort'))
