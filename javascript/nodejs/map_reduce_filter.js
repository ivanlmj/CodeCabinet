var numbers = [1, 2, 3, 4, 5]

var even = numbers.filter(a => a % 2 == 0);
var squares = numbers.map(a => Math.pow(a, 2));
var total = numbers.reduce((a, b) => a + b);

console.log("\nNumbers: " + numbers + "\n")

console.log(" - even: " + even);
console.log(" - squares: " + squares);
console.log(" - sum all nums: " + total + "\n");
