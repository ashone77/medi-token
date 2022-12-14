async function getDoctor() {
  const queryString = window.location.search;
  console.log(queryString);
  const urlParams = new URLSearchParams(queryString);
  const docId = urlParams.get("docId");
  console.log(docId);
  let url = `http://localhost:3001/api/doctors/${docId}`;
  try {
    let res = await fetch(url);
    return await res.json();
  } catch (error) {
    console.log(error);
  }
}

async function displayProfile() {
  let docs = await getDoctor();
  let html = "";

  let htmlSegment = `<div class="container">
        <div class="card text-white bg-dark mb-3 mt-5" style="max-width: auto;">
            <div class="card-header">Doctor Details</div>
            <div class="card-body">
                <div class="container pt-5 pb-5">
                    <div class="row gutters">
                        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                            <div class="card text-white h-100">
                                <div class="card-body">
                                    <div class="account-settings">
                                        <div class="user-profile">
                                            <h5 class="user-name">${docs.docName}</h5>
                                            <h6 class="user-email">${docs.docDesignation}</h6>
                                        </div>
                                        <div class="about">
                                            <h5 class="text-white">${docs.docDept}</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                            <div class="card text-white h-100">
                                <div class="card-body p-5">
                                    <div class="row gutters">
                                        <dl class="row">
                                            <dt class="col-sm-4">Working days :</dt>
                                            <dd class="col-sm-8">${docs.dayStart} - ${docs.dayEnd}</dd>
                                          
                                            <dt class="col-sm-4">Visiting Hours :</dt>
                                            <dd class="col-sm-8">${docs.timeStart} - ${docs.timeEnd}                                           
                                            </dd>
                                          
                                            <dt class="col-sm-4">Hospital Name:</dt>
                                            <dd class="col-sm-8">${docs.hospital}</dd>
                                            
                                            <dt class="col-sm-4">Location :</dt>
                                            <dd class="col-sm-8">${docs.location}</dd>
                                          
                                            
                                          </dl>
                                    </div>
                                    <div class="row gutters">
                                        <div class="form-group">
                                        <label for="exampleInputPassword1">Book Slot</label> </br>
                                        <small>Enter the date of visit and choose the time between given Start and End times.</small>
                                        <input type="text" class="form-control" id="token-time" placeholder="HR:MM AM/PM">
                                        <button id="btn-update" type="button" id="submit" name="submit"
                                                    class="btn btn-primary" onclick="confirmTime()">Confirm Time</button>
                                          </div>
                                          
                                    </div>
                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="text-right">
                                            <a href="./dashboard.html" class="btn btn-secondary btn-md" role="button" >Go Back</a>
                                                <button id="btn-update" type="button" id="submit" name="submit"
                                                    class="btn btn-primary" onclick="pdf()">Book Token</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
    </div>`;

  html += htmlSegment;

  let container = document.getElementById("doctor-profile");
  container.innerHTML = html;
}

displayProfile();
