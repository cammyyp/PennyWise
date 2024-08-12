import { BrowserRouter } from "react-router-dom";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import routes from "./routes/Routes";

function App() {
  return (
    <BrowserRouter basename="/">
      <Routes>
        {routes.map((route, index) => (
          <Route key={index} path={route.path} element={<route.component />} />
        ))}
      </Routes>
    </BrowserRouter>
  );
}
export default App;
