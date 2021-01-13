
import './App.css';
import Cam from './Cam'
import MenuAppBar from './component/MenuAppBar';
import Home from './component/Home'
import MyProfile from './component/MyProfile';
import { Router, Route, Switch,  browserHistory, IndexRoute } from 'react-router';


function App() {

  return (
    <div className="App">

  <MenuAppBar/>
      <Cam />

    </div>
  );
}

export default App;
