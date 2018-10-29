# install
https://kotlinlang.org/docs/tutorials/command-line.html
$ curl -s https://get.sdkman.io | bash
$ sdk install kotlin

# To compile:
kotlinc hello.kt -include-runtime -d hello.jar

# To run:
java -jar hello.jar
