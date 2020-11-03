package sort

//插入排序
//思想：循环未排序序列的每一个元素，在已排序队列中从后往前扫描，找到相应的位置并插入
//时间复杂度：O(n2)
//空间复杂度：O(1)
func InsertSort(array []int) {
	size := len(array)
	for i := 1; i < size; i++ {
		preIndex := i - 1
		currentVal := array[i]
		for preIndex >= 0 && array[preIndex] > currentVal {
			//往右位移
			array[preIndex+1] = array[preIndex]
			preIndex--
		}
		//找到合适的位置，插入
		array[preIndex+1] = currentVal
	}
}
