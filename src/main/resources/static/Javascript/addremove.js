function Item(id, itemName, quantity, buttonValue){
    this.id = id;
    this.itemName = itemName;
    this.quantity = quantity;
    this.buttonValue = buttonValue;
}


const item1 = new Item(1, "Apple", 3, "1");
const item2 = new Item(2, "Orange", 6,"2");
const item3 = new Item(3, "Pear", 12,"3");
const item4 = new Item(4, "Banana", 8,"4");
const item5 = new Item(5, "Mango", 1,"5");
const item6 = new Item(6, "Kiwi", 4,"6");
const item7 = new Item(7, "Carrot", 9,"7");
const item8 = new Item(8, "Tomato", 82,"8");

const myArray = [item1, item2, item3, item4, item5, item6, item7, item8];

window.onload = function tableGenerator(){
    
    let stringConstructor = "";
    document.getElementById("generated-table").innerHTML = stringConstructor; // clear table beforehand, just in case
    stringConstructor += "<table class=\"table\"><thead class=\"thead-dark\"><tr><th scope=\"col\">Item Name</th><th scope=\"col\">Item Quantity</th><th scope=\"col\">Action</th></tr></thead><tbody>";
    for (let i = 0; i < myArray.length; i++) {
        stringConstructor += "<tr><td>"+myArray[i].itemName+"</td><td>"+myArray[i].quantity+"</td><td><button id="+myArray[i].id+" value="+myArray[i].buttonValue+" type=\"button\">Delete Item!</button></td></tr>"
        
        
    }
    stringConstructor += "</tbody></table>"
    document.getElementById("generated-table").innerHTML = stringConstructor;
}

function removeElement(){
    
}