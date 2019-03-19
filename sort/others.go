package main

func insertSort(array []int) {
	size := len(array)
	for i := 1; i < size; i ++ {
		for j := i; j > 0 && array[j+1] > array[j]; j -- {
			swap(array, j, j-1)
		}
	}
}

func bubbleSort(array []int) {
	temp := len(array)
	for i := 0; i < temp; i++ {
		for j := 1; j < temp; j ++ {
			if array[i] > array[j] {
				swap(array, i, j)
			}
			temp --
		}
	}
}