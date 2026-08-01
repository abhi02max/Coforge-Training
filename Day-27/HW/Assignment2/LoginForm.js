import { useState } from "react";

function LoginForm() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");

  const validate = (e) => {
    e.preventDefault();

    let valid = true;

    if (email.length === 0) {
      setEmailError("Email should not be empty");
      valid = false;
    } else {
      setEmailError("");
    }

    if (password.length < 6) {
      setPasswordError("Password must be at least 6 characters");
      valid = false;
    } else {
      setPasswordError("");
    }

    if (valid) {
      alert("Login Successful");
    }
  };

  return (
    <form onSubmit={validate}>
      <h2>Login Form</h2>

      Email: 
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />
      <span style={{ color: "red" }}>{emailError}</span>
      <br /><br />

      Password:
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />
      <span style={{ color: "red" }}>{passwordError}</span>
      <br /><br />

      <button type="submit">Login</button>
    </form>
  );
}

export default LoginForm;