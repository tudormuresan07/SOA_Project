document.addEventListener('DOMContentLoaded', function () {
    let loginForm = document.getElementById("addClientForm");
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission behavior

        let firstName = document.getElementById("firstName");
        let lastName = document.getElementById("lastName");
        let email = document.getElementById("email");
        let age = document.getElementById("age");

        let client = {
            first_name: firstName.value,
            last_name: lastName.value,
            email: email.value,
            age: age.value
        };


        // Make a POST request using fetch
        fetch('http://localhost:8080/v1/gateway/client/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(client)
        })
        .then(response => {
            if(response.ok){
                console.log(response);
            alert('client added succesfully');
            document.getElementById("firstName").value="";
            document.getElementById("lastName").value="";
            document.getElementById("email").value="";
            document.getElementById("age").value="";
            // Handle success response
            }
            else {
                alert('client not added ')
            }
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle error
        });
    });
});