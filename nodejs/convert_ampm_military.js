
s = "07:05:45PM"
s_array = s.split(':');

console.log(`12-hour time:  ${s}`);

var hour = s_array[0];
var minute = s_array[1];
var seconds = s_array[2].slice(0, 2);
var day_period = s_array[2].slice(-2);

if ( day_period == "PM") {
    var hour_int = Number(hour);
    var hour_24 = hour_int + 12;
    hour = hour_24.toString();
}

console.log(`Military Time: ${hour}:${minute}:${seconds}`);
