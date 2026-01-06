function togglePassword() {
    const pwd = document.getElementById("password");
    pwd.type = pwd.type === "password" ? "text" : "password";
}

function checkStrength() {
    const pwd = document.getElementById("password").value;
    const strength = document.getElementById("strength");

    if (pwd.length < 6) {
        strength.textContent = "Weak password";
        strength.style.color = "red";
    } else if (pwd.match(/[A-Z]/) && pwd.match(/[0-9]/)) {
        strength.textContent = "Strong password";
        strength.style.color = "green";
    } else {
        strength.textContent = "Medium strength";
        strength.style.color = "orange";
    }
}

function handleSubmit() {
    const btn = document.getElementById("submitBtn");
    btn.disabled = true;
    btn.textContent = "Signing up...";
    return true;
}
