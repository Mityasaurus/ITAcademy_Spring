document
  .querySelectorAll("#btnPaymentSave")
  .forEach((btn) => btn.addEventListener("click", updatePayment));

function updatePayment() {
  console.log("updatePayment");
}
