
s = "12:40:22AM"
s_array = s.split(':');

console.log(`12-hour time:  ${s}`);

var hour = s_array[0];
var minute = s_array[1];
var seconds = s_array[2].slice(0, 2);
var day_period = s_array[2].slice(-2);

var hour_int = Number(hour);

if ( day_period == "PM" && hour_int != 12) {
    var hour_new = hour_int + 12;
    hour = hour_new.toString();
} else if ( day_period == "AM" && hour_int == 12) {
    var hour_new = hour_int - 12;
    hour = hour_new.toString();
    hour += "0";
}

console.log(`Military Time: ${hour}:${minute}:${seconds}`);
