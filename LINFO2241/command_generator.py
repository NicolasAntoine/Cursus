import random
import string

random_string = ''.join(random.choice(string.ascii_letters + string.digits) for _ in range(100))
print(random_string)

