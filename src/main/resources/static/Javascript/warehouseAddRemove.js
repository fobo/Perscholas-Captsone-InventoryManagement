console.log("Loaded JS");
console.log("jQuery version: " + jQuery.fn.jquery);

// $('document').ready(function(){
//   $('.table .updateCity').on('click', function(event){

//     event.preventDefault();
//     var href= $(this).attr('href');

//     console.log(wh);
//     $.get(href, function(wh, status){
//       $('#id').val(wh.id);
//       $('#city').val(wh.city);
//     });

//     $('#updateModal').modal();
//   })
// })

function testDisplay(test) {
  if (document.getElementById("portests").value == "Hide " + test) {
      document.getElementById("portests").value = "Show " + test;
      var table= document.getElementById("testing");
      for (var i = 0, row; row = table.rows[i]; i++) {
      if(row.className == "test"){row.style.visibility="hidden";}
      }
  }
  else{
      document.getElementById("portests").value = "Hide " + test;
      var table= document.getElementById("testing");
      for (var i = 0, row; row = table.rows[i]; i++) {
      if(row.className == "test"){row.style.visibility='visible';}
      }
  }
}




// $(document).ready(function(){document.querySelectorAll('.updateCity').forEach(button => {
//   button.addEventListener('click', event => {
//     // Retrieve the warehouse object from the data attribute
//     const wh = JSON.parse(button.dataset.whJson);

//     // Retrieve the id value from the data attribute using dot notation
//     const id = button.dataset.whId;

//     // Do something with the id value
//     console.log(`Clicked "Update" for warehouse ${id} in city ${wh.city}`);
//   });
// });});

// $(document).ready(function () {console.log("Loaded ready");
// $('.updateCity').off().on('click', function(e) {
//   const id = $(this).attr('data-id');
//   var row = $('tr[row-id="' + id + '"]')[0];
//   var city = $(row).find('.city').attr('text');
// });
// });


// var getDataForId = function (id) {
//   /*<![CDATA[*/
//   var warehouses = /*[[${warehouses}]]*/ [];
//   for (var i in warehouses) {
//   }
//   /*]]>*/
// };
//for delete
// $('.delete').off().on('show.bs.modal', function (event) {
//   var button = $(event.relatedTarget) // Button that triggered the modal
//   var recipient = button.data('whatever')
//    // Extract info from data-* attributes
//   const id = $(this)
//   //
//   // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
//   // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
//   var modal = $(this)
//   modal.find('.modal-title').text('New message to ' + recipient)
//   modal.find('.modal-body input').val(recipient)
// })
