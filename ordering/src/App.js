import "./App.css";
import LeftNav from "./components/LeftNav";
import Pos from "./pages/Pos";

import "antd/dist/antd.css";

function App() {
  return (
    <>
      <div id="app">
        {/* left nav */}
        <LeftNav />
        <div className="main">
          <Pos />
        </div>
      </div>
    </>
  );
}

export default App;
