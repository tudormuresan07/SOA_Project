document.addEventListener('DOMContentLoaded', function () {
    let loginForm = document.getElementById("addAlbumForm");
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission behavior

        let title = document.getElementById("title");
        let band = document.getElementById("band");

        let album = {
            title: title.value,
            band: band.value
        };


        // Make a POST request using fetch
        fetch('http://localhost:8080/v1/gateway/album/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(album)
        })
        .then(response => {
            if(response.ok){
            alert('Album added succesfully');
            document.getElementById("title").value="";
            document.getElementById("band").value="";
            // Handle success response
            }
            else {
                alert('Album not added ')
            }
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle error
        });
    });
});