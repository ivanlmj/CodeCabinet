

fruits <- c("apple", "grape", "orange", "papaya", "guaraná")
prices <- c(1.20, 3.90, 2.30, 2.60, 5.90)

# defining names/columns for prices
names(prices) <- fruits

print(">>> Fruit Vector:")
print(prices)
print(">>> First and Last elements:")
print(prices[c(1, 5)])
print(">>> From third to fifth element:")
print(prices[3:5])
print(">>> Price based on fruit name (guaraná):")
print(prices["guaraná"])
