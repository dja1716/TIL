function App() {
  const [user, setUser] = useState({
    name: "",
    surname: "",
    username: "",
    email: "",
    password: "",
    country: "",
    city: "",
    address: "",
  });

  const handleChange = (e) => {
    setUser((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  console.log(user);

  return (
    <div>
      <form>
        <input
          type="text"
          name="name"
          onChange={handleChange}
          placeholder="name"
        />
        <input
          type="text"
          name="surname"
          onChange={handleChange}
          placeholder="surname"
        />
        <input
          type="text"
          name="username"
          onChange={handleChange}
          placeholder="username"
        />
        <input
          type="text"
          name="email"
          onChange={handleChange}
          placeholder="email"
        />
        <input
          type="text"
          name="password"
          onChange={handleChange}
          placeholder="password"
        />
        <input
          type="text"
          name="country"
          onChange={handleChange}
          placeholder="country"
        />
        <input
          type="text"
          name="city"
          onChange={handleChange}
          placeholder="city"
        />
        <input
          type="text"
          name="address"
          onChange={handleChange}
          placeholder="address"
        />
      </form>
    </div>
  );
}
