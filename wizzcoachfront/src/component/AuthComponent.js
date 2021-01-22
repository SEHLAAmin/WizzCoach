import React , {useState} from 'react'
import MenuAppBarr from './MenuAppBar'
import Grid from '@material-ui/core/Grid'
import { TextField } from '@material-ui/core'
import { AmplifySignOut, withAuthenticator ,AmplifySignIn } from '@aws-amplify/ui-react'
import Auth from "@aws-amplify/auth";
import MenuAppBar from './MenuAppBar'
import {Avatar} from '@material-ui/core';
import Typography from '@material-ui/core/Typography'


const AuthComponent = () => {
 
    const [user , setUser] = React.useState(null)
    React.useEffect(() => {
        Auth.currentAuthenticatedUser()
.then(currentUser => { setUser(currentUser)


})
.catch(err => {
console.log(err);
});})

        async function signIn() {
            try {
                const user = await Auth.signIn(this.state.username, this.state.user.password);
            } catch (error) {
                console.log('error signing in', error);

            }
        }
    
        async function signOut() {
            try {
                await Auth.signOut();
            } catch (error) {
                console.log('error signing out: ', error);
            }
        };
    return (
        <div>
        <MenuAppBar />
        <Avatar>K</Avatar>
        
        {
            user && <Typography variant="h1" component="h2"> Hello
</Typography>
        }

        </div>
    )
}
export default withAuthenticator(AuthComponent);
