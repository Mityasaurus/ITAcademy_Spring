const forms = document.querySelectorAll("#payments-table-container form");

forms.forEach(function (form) {
  form.addEventListener("submit", function (event) {
    event.preventDefault();
    updatePayment(form);
  });
});

function updatePayment(form) {
  let formData = new FormData(form);
  let json = JSON.stringify(Object.fromEntries(formData));
  // console.log(json);
  //
  fetch(`/rest/paymentUpdateForm`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "X-CSRF-Token": formData.get("_csrf"),
    },
    body: json,
  })
    .then((response) => {
      // console.log(response);
    })
    .catch((error) => {
      console.log(error);
    });
}
