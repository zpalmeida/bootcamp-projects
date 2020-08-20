window.onload = function() {

  var ajax = new XMLHttpRequest();
  var table = document.getElementById('table');

  function hTMLString(customer) {
    return '<tr><td>' + customer.firstName + '</td><td>'
    + customer.lastName + '</td><td>'
    + customer.email + '</td><td>'
    + customer.phone + '</td><td>'
    + 'Edit</td> <td>Delete</td></tr>';
  };

  ajax.onreadystatechange = function() {

    if (ajax.readyState === 4 && ajax.status === 200) {

      var customerData = JSON.parse(ajax.responseText);

      customerData.forEach(function(item) {
        table.insertRow(-1).innerHTML = hTMLString(item);
      });
    }
  };

  ajax.open('GET', 'http://localhost:8080/javabank5/api/customer');
  ajax.setRequestHeader('Content-type', 'application/json');
  ajax.send();
}
