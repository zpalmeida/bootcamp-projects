window.onload = function() {

  var customerData = [
    {"id":1,"firstName":"Rui","lastName":"Ferrão","email":"rui@gmail.com","phone":"777888"},
    {"id":2,"firstName":"Sergio","lastName":"Gouveia","email":"sergio@gmail.com","phone":"777999"},
    {"id":3,"firstName":"Bruno","lastName":"Ferreira","email":"bruno@gmail.com","phone":"777666"},
    {"id":4,"firstName":"Rodolfo","lastName":"Matos","email":"rodolfo@gmail.com","phone":"777333"}
  ];

  var table = document.getElementById('table');

  function hTMLString(customer) {
    return '<tr><td>' + customer.firstName + '</td><td>'
    + customer.lastName + '</td><td>'
    + customer.email + '</td><td>'
    + customer.phone + '</td><td>'
    + 'Edit</td> <td>Delete</td></tr>';
  };

  customerData.forEach(function(item) {
    table.insertRow(-1).innerHTML = hTMLString(item);
  });
}
