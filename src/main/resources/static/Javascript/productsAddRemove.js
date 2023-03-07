$(document).ready(function() {
    $("button").click(function() {
      let id = $(this).data("value");
      console.log("Id clicked: " + id);
      let element = $('#' + id);
      console.log("element clicked:" + element);
      let hidden = element.attr("hidden");
      console.log("hidden clicked:" + hidden);
      if (!hidden) {
        element.attr("hidden", "hidden");
      } else {
        element.removeAttr("hidden");
      }
    });
  });