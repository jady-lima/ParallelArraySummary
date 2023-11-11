package main

import (
	"fmt"
	"math"
	"math/rand"
	"sync"
	"time"
)

var ElementId int = 1
var Total Results
var less []int
var greater []int

type Element struct {
	elementId int
	totalElement float32
	group int
}

type Results struct {
	SumTotal float32
	SumSubTotal1 float32
	SumSubTotal2 float32
	SumSubTotal3 float32
	SumSubTotal4 float32
	SumSubTotal5 float32
}

func addElements(numberElements int, elements []Element) []Element {
	elements = make([]Element, numberElements)

	for i := 0; i < numberElements; i++ {
		elements[i].elementId = ElementId;
		elements[i].group = rand.Intn(5) + 1
		elements[i].totalElement = rand.Float32() * 10
		ElementId++
	}
	
	return elements
}

func printElements(elements []Element) {
	for _, value := range elements {
		fmt.Printf("ID: %v, Group: %v, Total: %v\n", value.elementId, value.group, value.totalElement)
	}
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

func createRoutine(elements []Element, channel chan Element, waitGroup *sync.WaitGroup, numberElements int) {
	defer waitGroup.Done()

	for i := 0; i < len(elements); i++ {
		channel <- elements[i]
	}
}

func removeElements(idRoutine int, channel chan Element, waitGroup *sync.WaitGroup, part int) {
	defer waitGroup.Done()

	for i := (idRoutine * part); i < (part * (idRoutine + 1)); i++ {
		value := <- channel
		//fmt.Printf("Routina %v adicionou elemento ID: %v no canal \n", idRoutine, value.elementId)
		sumTotal(value)
		splitIds(value)
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
	var createRoutineWaitGroup sync.WaitGroup
	var elements[] Element

	fmt.Print("N: ")
	fmt.Scan(&N)
	fmt.Print("T: ")
	fmt.Scan(&T)

	numberElements = int(math.Pow10(N))
	part = numberElements / T
	channel := make(chan Element, numberElements)

	elements = addElements(numberElements, elements)
	//printElements(elements)

	waitGroup.Add(1)
	go createRoutine(elements, channel, &waitGroup, numberElements)

	startTime := time.Now()
	for i := 0; i < T; i++ {
		createRoutineWaitGroup.Add(1)
		go removeElements(i, channel, &createRoutineWaitGroup, part)
	}

	createRoutineWaitGroup.Wait()

	go func ()  {
		waitGroup.Add(1)
		defer waitGroup.Done()
		close(channel)	
	} ()
	
	waitGroup.Wait()

	endTime := time.Now()
	time := endTime.Sub(startTime)
	printResults()
	fmt.Println(len(less))
	fmt.Println(len(greater))
	fmt.Println("Time: ", time)
}