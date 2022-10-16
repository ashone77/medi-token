async function getDoctors() {
    let url = 'http://localhost:3001/api/doctors/';
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function doctorsList() {
    let docs = await getDoctors();
    let html = '';
    docs.forEach(doc => {
        let htmlSegment = `<div class="col-sm-6 mt-3">
        <div class="card text-white bg-dark">
          <div class="card-body">
          <h5 class="card-title">${doc.docName}</h5>
            <div className="row">
            <div className="col ">
            <p class="card-text">${doc.docDesignation}</p>
            <p class="card-text"> ${doc.docDept}</p>
            </div>
            
            </div>
            
            
            <a href="./doctordetails.html?docId=${doc.docId}" class="btn btn-primary mt-2">Show Details</a>
            
          </div>
        </div>
      </div>`;

        

        html += htmlSegment;
    });

    let container = document.getElementById('doctors-list');
    container.innerHTML = html;
}

doctorsList();