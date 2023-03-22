function App() {
  const [text, setText] = useState("");
  const [number, setNumber] = useState(0);

  const expensiveFunction = (n) => {
    console.log("Function re-rendered!");
    let total = 0;
    for (let i = 1; i < n; i++) {
      total += i;
    }

    return total;
  };

  const sum = useMemo(() => expensiveFunction(number), [number]);

  console.log("Component re-rendered!");

  return (
    <div>
      <input
        onChange={(e) => setText(e.target.value)}
        placeholder="enter a text"
      />
      <input
        onChange={(e) => setNumber(e.target.value)}
        value={number}
        placeholder="enter a number"
      />
      <span>Total: {sum}</span>
    </div>
  );
}
