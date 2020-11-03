package sort

//冒泡排序
//思想：每一趟循环通过比较大小并交换顺序，把最大（小）的值放到顶端
//时间复杂度：O(n2)
//空间复杂度：O(1)
func BubbleSort(array []int) {
	size := len(array)
	//外循环将数组排序排序
	for j := 0; j < size; j++ {
		//一个内循环筛选出一个最大值在数组最右侧
		for i := 1; i < size-j; i++ {
			if array[i-1] > array[i] {
				SwapElement(array, i-1, i)
			}
		}
	}
}
