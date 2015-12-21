//var theMeaningOfLife = 42,
//    foo = 'bar',
//    baz, quux;

//foo = baz;

//var number = 1;

//var string = 'hello';
//var quotes = '"hello", said the man"';
//var escaped = '"OH no! he didn\'t"';

//var array = [5, "something", true]; // array[0];
//var object = {
//    myNumber: 10,
//    myString: "yeahh"
//};

//object.myNumber; // 10
//object['myString']; // yeahh

//var postfix = 5;

var data = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight'];
var numCols = 1;           


$.each(data, function(i) {
    if(!(i%numCols)) tRow = $('<tr>');

    tCell = $('<td>').html(data[i]);

    $('table').append(tRow.append(tCell));
});
​