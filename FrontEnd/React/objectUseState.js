function App() {
  const [input, setInput] = useState("");
  const [user, setUser] = useState({
    name: "john",
    email: "john@gmail.com",
    images: ["profile.png", "cover.png"],
  });

  const changeUser = () => {
    setUser((prev) => ({ ...prev, name: input }));
  };

  console.log(user);

  return (
    <div>
      <h2>User:</h2>
      <input
        onChange={(e) => setInput(e.target.value)}
        placeholder="enter a new name..."
      />
      <button onClick={changeUser}>Change username</button>
      <span>Username is: {user.name}</span>
    </div>
  );
}
