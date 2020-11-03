package sort

import "math/rand"

func SwapElement(array []int, index1 int, index2 int) {
	temp := array[index1]
	array[index1] = array[index2]
	array[index2] = temp
}

func GenerateRandomArray(size int, maxNum int) []int {
	array := make([]int, 0, size)
	for i := 0; i < size; i++ {
		array = append(array, rand.Intn(maxNum))
	}
	return array
}