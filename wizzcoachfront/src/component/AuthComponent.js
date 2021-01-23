import React , {useState} from 'react'
import MenuAppBarr from './MenuAppBar'
import Grid from '@material-ui/core/Grid'
import { Box, TextField } from '@material-ui/core'
import { AmplifySignOut, withAuthenticator ,AmplifySignIn } from '@aws-amplify/ui-react'
import CardCate from './CardCate'
import Auth from "@aws-amplify/auth";
import MenuAppBar from './MenuAppBar'
import {Avatar} from '@material-ui/core';
import Typography from '@material-ui/core/Typography'
import UserForm from './UserForm'
import { withRouter } from "react-router";
import {currentUserPoolUser} from "@aws-amplify/auth"

const AuthComponent = () => {
/*const [user , setUser] = React.useState(null);*/

const [user, setUser] = React.useState(null)
React.useEffect(() => {
   /*fetchComments()
    subscribe()*/
    Auth.currentAuthenticatedUser()
    .then(user => {
      
      setUser(user).console.log('user:', user)
    })
    .then(currentUser => setUser(currentUser))
    .catch(err => console.log({ err }))
    /*fetchComments()
    subscribe()*/
  }, [])
    
    return (
        <div>
        <MenuAppBar /> 
        <Avatar>K</Avatar>{
     
            <Typography variant="h4" component="h4"> Êtes vous coach ou Noobie ?
</Typography>
        }
       <Grid
            container
            spacing={1}
            direction="row"
            justify="center"
            alignItems="center"
            alignContent="center"
            wrap="nowrap"
            container
            justify="space-around"
            
            >
            <Grid item><CardCate categoriesName ="Coach" / ></Grid>      
            <Grid item ><CardCate categoriesName ="Noobie" / ></Grid>
         
            </Grid>  <UserForm/>
        </div>
    )
}
export default withRouter(AuthComponent);
