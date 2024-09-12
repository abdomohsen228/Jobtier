
window.addEventListener('DOMContentLoaded', function() {
    const loader = document.getElementById('preloader');

    // Function to show preloader
    function showPreloader() {
        loader.style.display = 'block';
        loader.style.opacity = '.8'; // Ensure preloader is visible
        loader.classList.add('zoom-in'); // Apply zoom effect
    }

    // Function to hide preloader
    function hidePreloader() {
        loader.style.opacity = '0'; // Fade out
        setTimeout(() => {
            loader.style.display = 'none'; // Hide after fade
        }, 1000); // Match the fade-out transition duration
    }

    // Show preloader on page load
    showPreloader();
    window.addEventListener('load', function() {
        hidePreloader();
    });

    // Show preloader on link click
    document.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault(); // Prevent default link behavior
            showPreloader(); // Show the preloader

            // Delay navigation to ensure the preloader is visible
            setTimeout(() => {
                window.location.href = this.href; // Navigate to the new page
            }, 500); // Adjust this delay to control preloader visibility
        });
    });
});

