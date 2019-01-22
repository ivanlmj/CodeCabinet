# vector of days of the week, for naming other vectors
week <- c("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

# building vectors for profits/losses on each game
poker <- c(140, -50, 20, -120, 240)
roulette <- c(-24, -50, 100, -350, 10)

# naming vectors with days of the week as columns
names(poker) <- week
names(roulette) <- week

# presenting vectors
print("Profits and Losses: Poker")
print(poker)

print("Profits and Losses: Roulette")
print(roulette)

# calculating profits and losses per game
total_poker <- sum(poker)
total_roulette <- sum(roulette)

# presenting week results
print("Week results, based on both games:")
total_week <- total_poker + total_roulette
print(total_week)
