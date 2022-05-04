import numpy as np
import matplotlib.pyplot as plt

# Exemple de plot

x = np.linspace(-5, 5, 25) # 25 valeurs entre -5 et 5 (compris)
y = x ** 2

plt.plot(x, y)
plt.xlabel("x")
plt.ylabel("y")
plt.title("Une jolie parabole")
plt.show() # Affiche le graphique, non nécessaire dans un Notebook