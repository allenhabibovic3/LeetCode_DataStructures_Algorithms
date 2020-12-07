import random
import math

#decrypting cipertext with private key(d, n) needs fixing, encrypting with public key(e, n) works fine
#use charset ASCII 2^7 or 128 bits
def gcd(a, b):
	if a == 0:
		return b
	else:
		return gcd(b%a, a)

#if we factor a prime number n into a*b then a, b should be only factors of n besides 1 and n
def lcm(a, b):
	return ((a*b)/gcd(a, b))

def is_prime(n):
	#fix this later, runs in n time
	#look uip rabin-miller algo for better primality test
	for i in range(2, n):
		if n % i == 0:
			return False

	return True


def modInverse(a, m):
	#for finding, d the mod inverse of e, phi(n)
    a = a % m
    for x in range(1, m):
        if ((a * x) % m == 1):
            return x
    return 1


def gen_pubkey():
	#for any exchange compute PbK(e, n) and
	#corresponding SK(d, n)
	isPrimeP = False
	isPrimeQ = False
	p = 1
	q = 1
	while(not(isPrimeP and isPrimeQ)):
		p = random.randint(1, 10000)
		q = random.randint(1, 10000)
		isPrimeP = is_prime(p)
		isPrimeQ = is_prime(q)

	phi = (p-1)*(q-1) #eulers totient function: returns how many pos. ints <= n are co-prime(gcd(i, n)=1) with n
	n = p*q
	e = 0

	#if e should be co-prime with phi(n) then e is co-prime with n
	#1 < e <= phi(n)
	for i in range(2, phi+1):
		if gcd(i, phi) == 1:
			e = i
			break

	#generate the SK(d, n) private key pair for this exchange
	d = gen_skey(e, phi)
	#PUBLIC KEY
	return (e, n, d)


def encrypt(m, e, n):
	#to encrypt use: m^e mod n
	c = (m ** e) % n
	return c


def gen_skey(e, phi):
	#SK(d, n) where d*e mod phi(n) = 1
	#d is called mult. modular inverse of e
	return modInverse(e, phi)


def decrypt(c, d, n):
	#to get back m, use c^d mod n
	m = (c ** d) % n
	return m


plaintext = "DINO"
m = ""

for letter in plaintext:
	m_i = ord(letter)
	m += str(m_i)

m = int(m)

e, n, d = gen_pubkey()
c = encrypt(m, e, n)

print("first encrypt msg")
print(f"MSG={plaintext}, C={c}")

test1 = decrypt(c, d, n)
print(f"decrypted C={test1}")


