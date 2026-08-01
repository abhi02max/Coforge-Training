import { useState } from "react";

function CounterApplication() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const reset = () => {
    setCount(0);
  };

  return (
    <div>
      <h1>Counter Application</h1>

      <h2>Count: {count}</h2>

      <button onClick={increment}>Increment</button>

      <button onClick={decrement} >
        Decrement
      </button>

      <button onClick={reset}>
        Reset
      </button>
    </div>
  );
}

export default CounterApplication;