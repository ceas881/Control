document.getElementById('loginForm').addEventListener('submit', function (e) {
  e.preventDefault(); // Evita que el formulario se envíe

  const usernameOemail = document.getElementById('usernameOemail').value;
  const password = document.getElementById('password').value;

  // Enviar solicitud a la API
  fetch('http://localhost:3000/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ usernameOemail, password }),
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.token) {
        // Guardar el token en localStorage
        localStorage.setItem('token', data.token);
        document.getElementById('resultado').innerText = 'Inicio de sesión exitoso. Token guardado.';
      } else {
        document.getElementById('resultado').innerText = 'Error: ' + data.mensaje;
      }
    })
    .catch((error) => {
      console.error('Error:', error);
      document.getElementById('resultado').innerText = 'Error al conectar con la API';
    });
});