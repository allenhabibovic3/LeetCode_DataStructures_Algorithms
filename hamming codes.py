import numpy as np
from functools import reduce


def hamming_code(bits):
    on_bits = [i for i, bit in enumerate(bits) if bit]
    return reduce(lambda x, y: x ^ y, on_bits)


def hamming_distance(a, b):
    # len(a) = len(b) both n bit strings
    d = 0
    for i, bit in enumerate(a):
        if a[i] != b[i]:
            d += 1

    return d



def noise(bits):
    # flip a random bit in binary_str
    random_bit_position = np.random.randint(0, len(bits))
    if bits[random_bit_position]:
        bits[random_bit_position] = 0
    else:
        bits[random_bit_position] = 1


if __name__ == "__main__":
    # part 1
    # detect which bit is flipped by random noise, in our bin_str after calling noise
    raw_binary_str = "0010110001101010"

    bits = list(map(int, raw_binary_str))
    noise(bits)

    error_bit_pos = hamming_code(bits)

    print(f"original binary data = {raw_binary_str},\nafter random noise = {str(bits)},\nposition of error={error_bit_pos}")

    print("HAMMING DISTANCE = ", hamming_distance("001101", "001100"))


