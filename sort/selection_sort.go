package sort

//选择排序
//思想：每一趟循环选出未排序数组中的最小（大）值，并放在已排序数组的末尾
//时间复杂度：O(n2)
//空间复杂度：O(1)
func SelectionSort(array []int) {
	var (
		size        = len(array)
		sortedIndex = 0
		minVal      int
		minValIndex int
	)
	for i := sortedIndex; i < size-1; i++ {
		minVal = array[sortedIndex]
		minValIndex = sortedIndex
		for j := i + 1; j < size; j++ {
			if array[j] < minVal {
				minVal = array[j]
				minValIndex = j
			}
		}
		SwapElement(array, sortedIndex, minValIndex)
		sortedIndex++
	}
}
