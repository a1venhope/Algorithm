package sort

import (
	"sync"
)

// Golang Version

// use Go-Routinue
func QuickSort(wg *sync.WaitGroup, array []int, leftIndex int, rightIndex int) {
	defer wg.Done()
	if leftIndex >= rightIndex {
		return
	}
	midIndex := deal(array, leftIndex, rightIndex)
	wg.Add(2)
	go QuickSort(wg, array, leftIndex, midIndex-1)
	go QuickSort(wg, array, midIndex+1, rightIndex)
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
