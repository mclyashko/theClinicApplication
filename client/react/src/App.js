import {BrowserRouter} from "react-router-dom";
import AppRouter from "./component/AppRouter/AppRouter";
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div>
        <BrowserRouter>
            <AppRouter/>
        </BrowserRouter>
    </div>
  );
}

export default App;
