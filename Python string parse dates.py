#parse the dates for a string from MM/DD/YYYY To -> MONTH, DAY, LAST TWO YEAR

import re
from calendar import month_abbr

date_pattern = re.compile(r'(\d+)/(\d+)/(\d+)')

text = "Hello today is 10/7/2020, and my bday is on 11/19/2020"
month_list = month_abbr
month_index = [n for n in range(1,14)]

d = dict(zip(month_index, month_list))

for month, day, year in date_pattern.findall(text):
    print(f"{d[int(month)+1]} {day}, {year}")
