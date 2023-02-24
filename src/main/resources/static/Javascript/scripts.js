const wrapper = document.getElementById("bubble-wrapper");

const animateBubble = x => {
    const bubble = document.createElement("div");

    bubble.className = "bubble";

    bubble.style.left = `${x}px`;

    wrapper.appendChild(bubble);

    setTimeout(() => wrapper.removeChild(bubble), 2000);

}

window.onmousemove = e => animateBubble(e.clientX);



const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-button");

loginButton.addEventListener("click", (e) => {

    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if (username === "admin" && password === "password"){
        window.location.replace("stocksAddRemove.html");
    }

})

//constructors



//forloop to generate table on the go

//close table
