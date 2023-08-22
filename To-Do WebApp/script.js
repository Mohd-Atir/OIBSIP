let titleInput = document.getElementById("title-input");
let descInput = document.getElementById("desc-input");
let saveBtn = document.getElementById("save-btn");
let titleOutput = document.getElementById("title-output");
let descOutput = document.getElementById("desc-output");
let deleteBtn = document.getElementById("delete-btn");
let myBox = document.getElementById("box");
let arr = [];

let objStr = localStorage.getItem("data");
if (objStr != null) {
  arr = JSON.parse(objStr);
}
displayData();

saveBtn.onclick = () => {
  if (titleInput.value == "") {
    alert("Please enter title");
  } else if (descInput.value == "") {
    alert("Please enter description");
  } else {
    let inpData = titleInput.value;
    let descInpData = descInput.value;
    arr.push({ "title": inpData, "description": descInpData });
    saveData(arr);
    titleInput.value = "";
    descInput.value = "";
    displayData();
  }
};

function saveData(arr) {
  let str = JSON.stringify(arr);
  localStorage.setItem("data", str);
}

function displayData() {
  let display = "";
  arr.forEach((element, i) => {
    display += `
        <div class="content">
        <span id="title-output">${element.title}</span>
        <span id="desc-output">${element.description}</span>
        <button id="delete-btn" onclick=deleteData(${i})>X</button>
        </div>
        `;
  });
  myBox.innerHTML = display;
}

function deleteData(id) {
  arr.splice(id, 1);
  saveData(arr);
  displayData();
}
