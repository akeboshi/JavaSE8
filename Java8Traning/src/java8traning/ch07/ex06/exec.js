#! /usr/local/bin/jjs

function pipe () {
  var input
  for each (var command in arguments) {
    input = $EXEC(command,input)
  }
  return input
}

print(pipe('cat pipeTest.txt', 'grep -v a', 'sort'))
