import pandas as pd 
import matplotlib.pyplot as plt 

df = pd.read_csv('results.csv')
df.plot(x='transfer_per_sec', y='requests_per_sec')

plt.xlabel('transferpersec')
plt.ylabel('requestspersec')
plt.title("test")

plt.show()


print("hello world")