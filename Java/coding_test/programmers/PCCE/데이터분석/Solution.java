package Java.coding_test.programmers.PCCE.데이터분석;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Solution {

	// code date maximum remain
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		List<int[]> list = new ArrayList<>();
		if (ext.equals("date")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][1] < val_ext) {
					list.add(data[i]);
				}
			}
		} else if (ext.equals("code")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][0] < val_ext) {
					list.add(data[i]);
				}
			}
		} else if (ext.equals("maximum")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][2] < val_ext) {
					list.add(data[i]);
				}
			}
		} else if (ext.equals("remain")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][3] < val_ext) {
					list.add(data[i]);
				}
			}
		}
		Comparator<int[]> customComparator = (arr1, arr2) -> {
			if (sort_by.equals("date")) {
				return Integer.compare(arr1[1], arr2[1]);
			} else if (sort_by.equals("code")) {
				return Integer.compare(arr1[0], arr2[0]);
			} else if (sort_by.equals(("maximum"))) {
				return Integer.compare(arr1[2], arr2[2]);
			} else {
				return Integer.compare(arr1[3], arr2[3]);
			}
		};
		list.sort(customComparator);
		int[][] answer = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}