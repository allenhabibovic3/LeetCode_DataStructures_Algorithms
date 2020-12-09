import random

def estimate_pi(n):
	pts_in_circle = 0
	pts_in_total = 0

	for _ in range(n):
		x = random.uniform(0, 1)
		y = random.uniform(0, 1)

		dist = x ** 2 + y ** 2
		if dist <= 1:
			pts_in_circle += 1
		pts_in_total += 1

	pi = 4 * (pts_in_circle/pts_in_total)
	return pi

print(estimate_pi(100000))

