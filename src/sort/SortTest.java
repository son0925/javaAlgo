package sort;


public class SortTest {

	public static void main(String[] args) {
		int[] arr = {5,3,2,7,4,8,1,10,9,6};
//		bubbleSort(arr);
//		optimizedBubbleSort(arr);
//		insertionSort(arr);
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	
	// 시간 복잡도
	// worst: O(n^2)
	// best : O(n^2)
	// average: O(n^2)
	public static int[] bubbleSort(int[] arr) {
		// 정렬 과정이 거품이 수면으로 올라오는 모습과 흡사하여 지어진 이름
		// 라운드별 i 번째가 제일 큰 숫자 다음 라운드는 i--
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
		// 장점
		// 1. 추가적인 메모리 소비가 적다
		// 2. 구현이 매우 쉽다.
		// 3. 안정정렬이 가능하다
		// 단점
		// 교환 과정이 많아 많은 시간이 소비된다
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
	
	// 시간 복잡도
	// worst: O(N^2)
	// best : O(N)
	// average: O(N^2) <평균 시간복잡도가 O(N^2)중에서는 가장 빠르다
	public static int[] insertionSort(int[] arr) {
		// 현재 비교하는 타겟(i)와 비교(j,j-1...0)하는 원소들을 정렬하는 알고리즘이다
		// 현재 i -1 부터 비교를 하기 때문에 1부터 시작
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;
			// j >= 0가 먼저 앞에 와야함 - j = -1 일 때 arr[j]를 확인했을 때 오류가 생김
			while (j >= 0 && arr[j] > target) {
				// j + 1은 현재 타겟이 있는 위치
				arr[j+1] = arr[j];
				j--;
			}
			// 반복문을 탈출 했을 때는 j번째 값보다 크기 때문에 j+1위치에 target값을 저장한다
			arr[j+1] = target;
		}
		return arr;
		// 장점
		// 추가적인 메모리 소비가 작다
		// 거의 정렬된 경우 매우 효율적이다 최선의 경우 O(N)의 시간복잡도
		// 안정정렬이 가능하다
		// 단점
		// 배열 크기가 역순에 가까울 수록 비효율적이다 최악의 경우 O(N^2)의 시간 복잡도를 가진다
		// 데이터의 상태에 따라 편차가 매우 크다
	}
	
	
	public static int[] selectionSort(int[] arr) {
		// 삽입정렬
		// 주어진 리스트의 최소값을 찾는다
		// 현재 라운드 i번째의 위치의 값과 최소값의 위치를 바꾼다
		// i는 최소값을 놔둘 위치
		for (int i = 0; i < arr.length; i++) {
			// j는 최소값을 찾는 for문
			int minIdx = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			// swap하기
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
		return arr;
		// 장점
		// 추가적인 메모리 소비가 작다
		// 단점
		// 시간복잡도가 O(N^2)
		// 안정 정렬이 아니다
		// [B2,B1,A,C] => A < B1 , B2 < C라고 할 때 정렬을 하면 A, B2, B1, C로 정렬이 된다 같은 값일 때 이름 순서로 정렬을 하지 못한다는 단점이 있다
		// 이러한 상태를 불안정정렬이라고 한다
		// 선택 정렬
	}

}
