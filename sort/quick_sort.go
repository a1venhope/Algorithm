package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

// Golang Version

// use Go-Routinue
func sort(wg *sync.WaitGroup, array []int, leftIndex int, rightIndex int) {
	defer wg.Done()
	if leftIndex >= rightIndex {
		return
	}
	midIndex := deal(array, leftIndex, rightIndex)
	wg.Add(2)
	go sort(wg, array, leftIndex, midIndex-1)
	go sort(wg, array, midIndex+1, rightIndex)
}

func deal(array []int, leftIndex int, rightIndex int) int {
	flag := array[leftIndex]
	l := leftIndex + 1
	r := rightIndex
	var temp int
	for l < r {
		for l < r && array[r] >= flag {
			r --
		}
		temp = array[r]
		for l < r && array[l] <= flag {
			l ++
		}
		array[r] = array[l]
		array[l] = temp
	}
	array[leftIndex] = temp
	array[l] = flag
	print(array, l)
	return l
}

func main() {
	array := make([]int, 10)
	rand.Seed(time.Now().Unix())
	for i := 0; i < len(array); i ++ {
		array[i] = rand.Intn(100)
	}
	print(array, -1)
	var wg *sync.WaitGroup
	wg.Add(1)
	go sort(wg, array, 0, len(array)-1)
	wg.Wait()
	print(array, -1)
}