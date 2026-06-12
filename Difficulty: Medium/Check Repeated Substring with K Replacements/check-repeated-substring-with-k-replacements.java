class Solution {
	public boolean kSubstr(String s, int k) {
		int n = s.length();
		if (n%k != 0)
			return false;
		HashMap<String, Integer> map = new HashMap<>();
		int i = 0;
		while (i<n) {
			String temp = s.substring(i, i + k);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			i += k;
		}
		int size = map.size();
		if (size == 1)
			return true;
		if ((size == 2) && map.containsValue(1))
			return true;
		return false;
	}
}