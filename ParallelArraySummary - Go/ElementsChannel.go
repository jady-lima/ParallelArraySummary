package main

import (
	"fmt"
	"math"
	"math/rand"
	"sync"
)

var ElementId int = 1
var Total Results
var less []int
var greater []int

type Element struct {
	elementId    int
	totalElement float32
	group        int
}

type Results struct {
	SumTotal float32
	SumSubTotal1 float32
	SumSubTotal2 float32
	SumSubTotal3 float32
	SumSubTotal4 float32
	SumSubTotal5 float32
}

func addElements(numberElements int, channel chan Element, waitGroup *sync.WaitGroup) {
	defer waitGroup.Done()

	for i := 0; i < numberElements; i++ {
		var element Element
		element.elementId = ElementId
		element.group = rand.Intn(5) + 1
		element.totalElement = rand.Float32() * 10
		channel <- element
		ElementId++
	}
	close(channel)
}

func sumTotal(valor Element) {
	Total.SumTotal += valor.totalElement

	switch valor.group {
	case 1:
		Total.SumSubTotal1 += valor.totalElement
	case 2:
		Total.SumSubTotal2 += valor.totalElement
	case 3:
		Total.SumSubTotal3 += valor.totalElement
	case 4:
		Total.SumSubTotal4 += valor.totalElement
	case 5:
		Total.SumSubTotal5 += valor.totalElement
	}
}

func splitIds(valor Element) {
	if valor.totalElement < 5 {
		less = append(less, valor.elementId)
	} else if valor.totalElement >= 5 {
		greater = append(greater, valor.elementId)
	}
}

func removeElements(part int, channel chan Element, waitGroup *sync.WaitGroup, idRoutine int) {
	defer waitGroup.Done()

	for i := 0; i < part; i++ {
		valor := <- channel
		sumTotal(valor)
		splitIds(valor)
		
		//fmt.Printf("Rotina %v - ID: %v, Group: %v, Total: %v\n", idRoutine, valor.elementId, valor.group, valor.totalElement)
	}
}

func printResults() {
	fmt.Printf("1. Resultado total: %v \n", Total.SumTotal)
	fmt.Printf("2. Resultado total grupo 1: %v \n", Total.SumSubTotal1)
	fmt.Printf("3. Resultado total grupo 2: %v \n", Total.SumSubTotal2)
	fmt.Printf("4. Resultado total grupo 3: %v \n", Total.SumSubTotal3)
	fmt.Printf("5. Resultado total grupo 4: %v \n", Total.SumSubTotal4)
	fmt.Printf("6. Resultado total grupo 5: %v \n", Total.SumSubTotal5)
}

func main() {
	var N int
	var T int
	var part int
	var numberElements int
	var waitGroup sync.WaitGroup

	fmt.Print("N: ")
	fmt.Scan(&N)
	fmt.Print("T: ")
	fmt.Scan(&T)

	numberElements = int(math.Pow10(N))
	channel := make(chan Element, numberElements)
	part = numberElements / T

	waitGroup.Add(1)
	go addElements(numberElements, channel, &waitGroup)

	for i := 0; i < T; i++ {
		waitGroup.Add(1)
		go removeElements(part, channel, &waitGroup, i)
	}

	waitGroup.Wait()

	printResults()
	fmt.Println(less)
	fmt.Println(greater)
}
