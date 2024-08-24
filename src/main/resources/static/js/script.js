console.log("Script loaded");
// localStorage.clear();
let currentTheme = getTheme();
//  console.log(currentTheme);
document.addEventListener("DOMContentLoaded",()=>{changeTheme();
})

function changeTheme() {
    // Set the theme to the webpage
    document.querySelector('html').classList.add(currentTheme);

    // Set the listener for the theme change button
    const changeThemeButton = document.querySelector('#theme_change_button');
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme = currentTheme;
        console.log("change theme button clicked");

        // Remove the current theme class from the HTML element
        document.querySelector("html").classList.remove(currentTheme);

        // Toggle between "dark" and "light" themes
        if (currentTheme === "dark") currentTheme = "light";
        else currentTheme = "dark";

        // Save the new theme in local storage
        setTheme(currentTheme);

        // Apply the new theme class to the HTML element
        document.querySelector('html').classList.add(currentTheme);

        // Change the text of the button to indicate the current theme
        changeThemeButton.querySelector('span').textContent = currentTheme=='light'?'Dark':'Light';
    });
}

// Set theme to local storage
function setTheme(theme) {
    window.localStorage.setItem("theme", theme);
}

// Get theme from local storage
function getTheme() {
    let theme = window.localStorage.getItem("theme");
    if (theme === "dark" || theme === "light") {
        return theme;
    } else {
        return "light";
    }
}

