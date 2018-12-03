package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Type your message: ")
	text, _ := reader.ReadString('\n')
	fmt.Println("Your message: ", text)
}
