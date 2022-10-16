function generatePDF(){
    const element = document.getElementById("token-template");

    html2pdf()
    .from(element)
    .save();
}