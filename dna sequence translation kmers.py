def get_kmers(sequence, k=6):
	return [sequence[x:x+k] for x in range(len(sequence) - k + 1)]

sequence = "ATGCATGCAA"
k_mers = get_kmers(sequence)

print(k_mers)
