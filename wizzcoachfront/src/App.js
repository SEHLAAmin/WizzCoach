
import './App.css';
import Cam from './Cam'
import MenuAppBar from './component/MenuAppBar';
import Home from './component/Home'
import { Router, Route, Switch,  browserHistory, IndexRoute  } from 'react-router';
import {BrowserRouter } from 'react-router-dom'
import { Box } from '@material-ui/core';
import CardCate from './component/CardCate';
import Auth from './component/AuthComponent';


//config Amplify
import Amplify from 'aws-amplify';
import config from './aws-exports';
import AuthComponent from './component/AuthComponent';
Amplify.configure(config);

/////

function App() {

  return (
    <div className="App">
    <BrowserRouter>
  <Switch>
    <Route exact from="/" render = {props => <Home {...props} />}/>
    <Route exact from="/Auth" render = {props => <Auth {...props} />}/>

  </Switch>
</BrowserRouter>
    </div>
  );
}

export default App;
