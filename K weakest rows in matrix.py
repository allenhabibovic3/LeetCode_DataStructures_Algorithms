class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        result = []
        for i in range(len(mat)):
	        result.append((sum(mat[i]), i))
        return [r[1] for r in sorted(result)[:k]]
