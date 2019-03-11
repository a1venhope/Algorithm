package main

func swap(array []int, index1 int, index2 int) {
	temp := array[index1]
	array[index1] = array[2]
	array[index2] = temp
}

func print(array []int, midIndex int) {
	for i := 0; i <len(array); i ++ {
		if i == midIndex {
			fmt.Printf("(%d)  ", array[i])
		} else {
			fmt.Printf("%d    ", array[i])
		}
	}
	fmt.Println()
}