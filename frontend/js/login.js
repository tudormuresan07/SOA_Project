document.addEventListener('DOMContentLoaded', function () {
    let loginForm = document.getElementById("loginForm");
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); 

        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;

        fetch('http://localhost:8080/v1/gateway/client/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
        })
        })
        .then(response => {
            if(response.ok){
            alert('login successful');
            document.getElementById("email").value="";
            }
            else {
                alert('login unsuccessful')
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});