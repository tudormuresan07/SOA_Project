function loadDropdownOptions_Client() {
    let dropdown_client = document.getElementById("dropdown_client");

    fetch('http://localhost:8080/v1/gateway/client/clients')
        .then(response => response.json())
        .then(data => {
            data.forEach(option => {
                let optionElement = document.createElement("option");
                optionElement.value = option.userId ;
                optionElement.text = option.first_name+ " " + option.last_name;
                dropdown_client.appendChild(optionElement);
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function loadDropdownOptions_Album() {
    let dropdown = document.getElementById("dropdown_album");

    fetch('http://localhost:8080/v1/gateway/album/albums')
        .then(response => response.json())
        .then(data => {
            data.forEach(option => {
                let optionElement = document.createElement("option");
                optionElement.value = option.title;
                optionElement.text = option.title + " - "+ option.band ;
                dropdown.appendChild(optionElement);
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}


document.addEventListener('DOMContentLoaded', function () {
    loadDropdownOptions_Client();
    loadDropdownOptions_Album();

    let loginForm = document.getElementById("buyAlbumForm");
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();

        let clientId = document.getElementById("dropdown_client").value;
        let title = document.getElementById("dropdown_album").value;

        const url = `http://localhost:8080/v1/gateway/album/${clientId}/clients/${title}`;

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                    clientId: clientId,
                    title: title
            })
        })
        .then(response => {
            if (response.ok) {
                alert('The album was successfully bought');
                loadDropdownOptions_Client();
                loadDropdownOptions_Album();
            } else {
                alert(`Error: ${response.statusText}`);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });


    });

});