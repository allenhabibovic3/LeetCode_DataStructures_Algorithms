from matplotlib import pyplot as plt

slices = [59219, 55466, 47544, 36443, 35917]
labels = ['JavaScript', 'HTML/CSS', 'SQL', 'Python', 'Java']
explode = [0, 0, 0, 0.1, 0]

plt.pie(slices, explode=explode, autopct='%1.1f%%', shadow=True, labels=labels, wedgeprops={'edgecolor': 'black'})

plt.style.use('fivethirtyeight')
plt.tight_layout()
plt.show()
