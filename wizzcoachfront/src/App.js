
import React from 'react'
import './App.css';
import {theme} from './component/theme'
import Cam from './Cam'
import MenuAppBar from './component/MenuAppBar';
import Home from './component/Home'
import { Router, Route, Switch,  browserHistory, IndexRoute  } from 'react-router';
import { Box } from '@material-ui/core';
import CardCate from './component/CardCate';
import {Auth} from '@aws-amplify/auth';
import UserForm from './component/UserForm'
import { AmplifySignOut, withAuthenticator ,AmplifySignIn } from '@aws-amplify/ui-react'

//config Amplify
import Amplify from 'aws-amplify';
import config from './aws-exports';
import AuthComponent from './component/AuthComponent';
import { BrowserRouter } from 'react-router-dom';
Amplify.configure(config);

/////

function App(props) {

  const {history } = props;
const [user , setUser] = React.useState(null)
React.useEffect(() => {
  Auth.currentAuthenticatedUser().then(currentUser => setUser(currentUser))
  .catch(err => console.log({err}))
    } , [])
  return (
    <div className="App">
    <BrowserRouter>
  <Switch>
    <Route exact from="/" render = {props => <Home {...props} />}/>
    <Route exact from="/authsign" render = {props => <AmplifySignIn {...props} />}/>
    <Route exact from="/Auth" render = {props => <AuthComponent {...props} />}/>
    <Route exact from = "/Auth/UserForm" render = {props => <UserForm {...props} />}/>
  </Switch>
</BrowserRouter>
    </div>
  );
}

export  default  withAuthenticator(App);
