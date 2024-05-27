package sort;


public class SortTest {

	public static void main(String[] args) {
		int[] arr = {5,3,2,7,4,8,1,10,9,6};
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	
	
	public static int[] bubbleSort(int[] arr) {
		// 정렬 과정이 거품이 수면으로 올라오는 모습과 흡사하여 지어진 이름
		// 마지막에 있는 숫자가 제일 큰 숫자로 정렬되었으며 n-2,3,4,5만큼 돈다
		for (int i = arr.length-1; i>=0; i--) {
			for (int j = 0; j < i; j++) {
				// j, j+1을 비교하여 더 큰 숫자를 뒤에 놔두며 한바퀴를 돈다
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] optimizedBubbleSort(int[] arr) {
		// 버블 정렬 최적화
		boolean swapped;
		for (int i = arr.length-1; i >= 0; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			// 바뀌지 않았다면 종료하기
			if (!swapped) {
				break;
			}
		}
		
		return arr;
	}

}
