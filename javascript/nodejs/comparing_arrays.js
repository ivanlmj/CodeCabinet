
var a = [5, 6, 7]
var b = [3, 6, 10]

var alice_points = 0
var bob_points = 0

var final_score = []

// in raw JS, the 'i' variable must have
// a 'var' declaration for the asignment on this loop
for (i=0; i < a.length; i++) {
    if ( a[i] > b[i] ) {
        alice_points++;
    } else if ( a[i] < b[i] ) {
	bob_points++;
    }
}

final_score.push(alice_points);
final_score.push(bob_points);

console.log(final_score);
