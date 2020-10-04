# Complete the marsExploration function below.
def marsExploration(s):
    s = s.upper()
    n = len(s) / int(3);
    og_msg = "SOS" * int(n)

    count = 0
    for i in range(len(s)):
     if s[i] != og_msg[i]:
      count += 1
    return count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = marsExploration(s)

    fptr.write(str(result) + '\n')

    fptr.close()
